package com.example.thomas.biosapp.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;

import com.example.thomas.biosapp.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Created by Julian on 29-3-2018.
 */

public class QRCodeGeneratorTask extends AsyncTask<String, Void, Bitmap> {

    private int QRcodeWidth = 500;
    private Bitmap bitmap;
    private OnQRCodeGenerated qrCodeListener;
    private int colorPrimary;
    private int colorSecondary;

    public QRCodeGeneratorTask(int colorPrimary, int colorSecondary, OnQRCodeGenerated qrCodeListener) {
        this.colorPrimary = colorPrimary;
        this.colorSecondary = colorSecondary;
        this.qrCodeListener = qrCodeListener;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        try {
            BitMatrix bitMatrix;
            try {
                bitMatrix = new MultiFormatWriter().encode(
                        strings[0],
                        BarcodeFormat.DATA_MATRIX.QR_CODE,
                        QRcodeWidth, QRcodeWidth, null
                );

            } catch (IllegalArgumentException Illegalargumentexception) {

                return null;
            }
            int bitMatrixWidth = bitMatrix.getWidth();

            int bitMatrixHeight = bitMatrix.getHeight();

            int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

            for (int y = 0; y < bitMatrixHeight; y++) {
                int offset = y * bitMatrixWidth;

                for (int x = 0; x < bitMatrixWidth; x++) {

                    pixels[offset + x] = bitMatrix.get(x, y) ?
                            colorPrimary : colorSecondary;
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

            bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
            System.out.println(0);
            qrCodeListener.onQRCodeGenerated(bitmap);
            return bitmap;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
