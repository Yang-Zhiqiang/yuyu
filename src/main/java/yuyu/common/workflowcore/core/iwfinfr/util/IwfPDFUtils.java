package yuyu.common.workflowcore.core.iwfinfr.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import yuyu.common.workflowcore.iwfcommon.pga.PdfMask;
import yuyu.common.workflowcore.iwfcommon.pga.PdfPage;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.SimpleBookmark;

/**
 * 帳票関連ユーティリティ
 */
public class IwfPDFUtils {

    private IwfPDFUtils() {
    }

    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    public static byte[] concatPDF(ArrayList<byte[]> poAryPDFs) throws Exception {
        ByteArrayOutputStream oOutStream       = new ByteArrayOutputStream();
        PdfReader             oPDF_Reader      = null;
        int                   iPDF_PageCnt     = 0;
        List                  oLstPDF_Bookmark  = null;
        int                   iCount           = 0;
        int                   iPDF_PageOffset  = 0;
        ArrayList             oAryPDF_Bookmarks = new ArrayList();
        Document              oPDF_Doc         = null;
        PdfCopy               oPDF_Copy        = null;
        PdfImportedPage       oPDF_Page        = null;
        PRAcroForm            oPDF_Form        = null;

        while(iCount < poAryPDFs.size()) {

            oPDF_Reader     = new PdfReader((poAryPDFs.get(iCount)));
            oPDF_Reader.consolidateNamedDestinations();

            iPDF_PageCnt    = oPDF_Reader.getNumberOfPages();
            oLstPDF_Bookmark = SimpleBookmark.getBookmark(oPDF_Reader);
            if(oLstPDF_Bookmark != null) {
                if(iPDF_PageOffset != 0) {
                    SimpleBookmark.shiftPageNumbers(oLstPDF_Bookmark, iPDF_PageOffset, null);
                }
                oAryPDF_Bookmarks.addAll(oLstPDF_Bookmark);
            }
            iPDF_PageOffset += iPDF_PageCnt;
            if(iCount == 0) {

                oPDF_Doc  = new Document(oPDF_Reader.getPageSizeWithRotation(1));

                oPDF_Copy = new PdfCopy(oPDF_Doc, oOutStream);

                oPDF_Doc.open();
            }

            for(int iI=0; iI<iPDF_PageCnt;) {
                ++iI;
                oPDF_Page = oPDF_Copy.getImportedPage(oPDF_Reader, iI);
                oPDF_Copy.addPage(oPDF_Page);
            }
            oPDF_Form = oPDF_Reader.getAcroForm();
            if(oPDF_Form != null) {
                oPDF_Copy.copyAcroForm(oPDF_Reader);
            }
            iCount++;
        }
        if(oAryPDF_Bookmarks.size() > 0) {
            oPDF_Copy.setOutlines(oAryPDF_Bookmarks);
        }

        oPDF_Doc.close();

        return oOutStream.toByteArray();
    }

    public static byte[] convBlob2Bytes(Blob poInput) throws Exception{


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream          os   = new BufferedOutputStream(baos);
        int i;
        byte[] bytes;

        try{

            InputStream is = poInput.getBinaryStream();

            while((i = is.read()) != -1){

                os.write(i);
            }

            os.flush();
            bytes = baos.toByteArray();
        }finally{
            os.close();
            baos.close();
        }
        return bytes;
    }

    public static PdfPage[] split(PdfReader poReader) throws Exception {


        int iPages = poReader.getNumberOfPages();
        PdfPage[] oBeans = new PdfPage[iPages];

        try {

            for (int iI = 1; iI <= iPages; iI++) {

                ByteArrayOutputStream oBaos = new ByteArrayOutputStream();
                Document oPdfDocument = new Document(poReader.getPageSizeWithRotation(iI));
                PdfWriter oWriter = PdfWriter.getInstance(oPdfDocument, oBaos);


                oPdfDocument.open();
                PdfContentByte oContentByte = oWriter.getDirectContent();
                oPdfDocument.setPageSize(poReader.getPageSizeWithRotation(iI));
                oPdfDocument.newPage();
                PdfImportedPage oImportedPage = oWriter.getImportedPage(poReader, iI);
                int iRotation = poReader.getPageRotation(iI);

                if (iRotation == 90) {
                    oContentByte.addTemplate(oImportedPage, 0, -1f, 1f, 0, 0, poReader.getPageSizeWithRotation(iI).getHeight());
                }
                else if (iRotation == 180) {
                    oContentByte.addTemplate(oImportedPage, -1f, 0, 0, -1f, poReader.getPageSizeWithRotation(iI).getWidth(), poReader.getPageSizeWithRotation(iI).getHeight());
                }
                else if (iRotation == 270) {
                    oContentByte.addTemplate(oImportedPage, 0, 1f, -1f, 0, poReader.getPageSizeWithRotation(iI).getWidth(), 0);
                }
                else {
                    oContentByte.addTemplate(oImportedPage, 1f, 0, 0, 1f, 0, 0);
                }
                oPdfDocument.close();

                oBeans[iI - 1] = new PdfPage();
                oBeans[iI - 1].setS_pdfdata(oBaos.toByteArray());
            }
            return oBeans;
        }
        catch (Exception e1) {
            e1.printStackTrace();
            throw e1;
        }
    }

    public static void mask(PdfWriter poPdfWriter, PdfMask[] poPdfMasks) {

        PdfContentByte oContentByte = poPdfWriter.getDirectContent();

        for (int iI = 0; iI < poPdfMasks.length; iI++) {

            oContentByte.setLineWidth(poPdfMasks[iI].getWeight());

            oContentByte.moveTo(poPdfMasks[iI].getStartX(), poPdfMasks[iI].getStartY());

            oContentByte.lineTo(poPdfMasks[iI].getEndX(), poPdfMasks[iI].getStartY());

            oContentByte.stroke();
        }
    }

    public static void encrypt(PdfReader poPdfReader, OutputStream poOutputStream, PdfSecurityConfig config) throws Exception {

        byte[] btUserPass  = new byte[0];
        byte[] btOwnerPass = new byte[0];
        int    iAllow      = 0;

        if (config != null){

            if (config.sUserPassword != null) {
                btUserPass = config.sUserPassword.getBytes();
            }

            if (config.sOwnerPassword != null) {
                btOwnerPass = config.sOwnerPassword.getBytes();
            }

            if (!config.canPrinting) {
                iAllow |= PdfWriter.AllowPrinting;
            }

            if (!config.canModifyContents) {
                iAllow |= PdfWriter.AllowModifyContents;
            }

            if (!config.canCopy) {
                iAllow |= PdfWriter.AllowCopy;
            }

            if (!config.canModifyAnnotations) {
                iAllow |= PdfWriter.AllowModifyAnnotations;
            }
        }


        PdfEncryptor.encrypt(poPdfReader, poOutputStream, btUserPass, btOwnerPass, iAllow, true);
    }
    public static class PdfSecurityConfig{
        public String sUserPassword;
        public String sOwnerPassword;
        public boolean canPrinting;
        public boolean canModifyContents;
        public boolean canCopy;
        public boolean canModifyAnnotations;

        public static PdfSecurityConfig newDefaultInstance(){
            PdfSecurityConfig config = new PdfSecurityConfig();
            config.sOwnerPassword       = "iwf";
            config.canPrinting          = false;
            config.canModifyContents    = true;
            config.canCopy              = true;
            config.canModifyAnnotations = true;
            return config;
        }
    }
}
