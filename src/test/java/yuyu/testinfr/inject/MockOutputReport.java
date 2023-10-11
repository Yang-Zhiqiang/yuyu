package yuyu.testinfr.inject;

import yuyu.infr.report.OutputReport;

import com.google.common.base.Strings;

public class MockOutputReport extends OutputReport {

    private static final int GETMODE_SINGLE      = 0;
    private static final int GETMODE_JOINED      = 1;
    private static final int GETMODE_MULTI       = 2;
    private static final int GETMODE_MULTIJOINED = 3;
    private static final int GETMODE_DEL         = 4;
    private static final int GETMODE_DEL_JOINED  = 5;

    private String outputPath = "test_out/";

    public void setOutputPath(String pOutputPath){
        outputPath = pOutputPath;
    }

    @Override
    public String outputPDFSingle(String pTyouhyouKey) {

        return outputTestResultPdf(new String[]{pTyouhyouKey}, GETMODE_SINGLE);
    }

    @Override
    public String outputPDFByJoinKey(String pTyouhyouJoinKey) {

        return outputTestResultPdf(new String[]{pTyouhyouJoinKey}, GETMODE_JOINED);
    }

    @Override
    public String outputPDFByKeys(String[] pTyouhyouKeys) {

        return outputTestResultPdf(pTyouhyouKeys, GETMODE_MULTI);
    }

    @Override
    public String outputPDFByJoinKeys(String[] pTyouhyouJoinKeys) {

        return outputTestResultPdf(pTyouhyouJoinKeys, GETMODE_MULTIJOINED);
    }

    @Override
    public String outputPDFWithDel(String pTyouhyouKey) {

        return outputTestResultPdf(new String[]{pTyouhyouKey}, GETMODE_DEL);
    }

    @Override
    public String outputPDFWithDelByJoinKey(String pTyouhyouJoinKey) {

        return outputTestResultPdf(new String[]{pTyouhyouJoinKey}, GETMODE_DEL_JOINED);
    }

    private String outputTestResultPdf(String[] pTyouhyouKey, int pMode){

        if(!Strings.isNullOrEmpty(outputPath)){
            outputPath = outputPath.replace('\\', '/');
            if(!outputPath.substring(outputPath.length() - 1).equals("/")) outputPath = outputPath + "/";
        }

        @SuppressWarnings("deprecation")
        byte[] pdfDatas = (byte[])MockUtil.forceCall(this, "getPdfImages", new Class<?>[]{String[].class, int.class}, new Object[]{pTyouhyouKey, pMode});

        if (pdfDatas == null || pdfDatas.length == 0) {
            return ACTIONMAPPING_IMAGEERROR;
        }

        outputPDF2File(pdfDatas, outputPath);

        return null;
    }
}
