package yuyu.infr.report;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.infr.report.swakreport.config.EncryptInfoConfig;
import yuyu.infr.report.swakreport.config.ReportConfig;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**
 * PDFオブジェクトを操作するためのユーティリティクラスです。
 */
public class PdfUtil {

    private PdfUtil(){
    }

    public static PdfHozonBean[] split(PdfReader pReader) {

        int pages = pReader.getNumberOfPages();
        PdfHozonBean[] pdfHozonBeans = new PdfHozonBean[pages];

        for (int iI = 1; iI <= pages; iI++) {
            try(ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
                Document pdfDocument = new Document(pReader.getPageSizeWithRotation(iI));
                PdfWriter writer = PdfWriter.getInstance(pdfDocument, baos);

                pdfDocument.open();
                PdfContentByte contentByte = writer.getDirectContent();
                pdfDocument.setPageSize(pReader.getPageSizeWithRotation(iI));
                pdfDocument.newPage();
                PdfImportedPage importedPage = writer.getImportedPage(pReader, iI);

                int rotation = pReader.getPageRotation(iI);
                if (rotation == 90 || rotation == 270) {
                    contentByte.addTemplate(importedPage, 0, -1f, 1f, 0, 0, pReader.getPageSizeWithRotation(iI).getHeight());
                }
                else {
                    contentByte.addTemplate(importedPage, 1f, 0, 0, 1f, 0, 0);
                }
                pdfDocument.close();

                pdfHozonBeans[iI - 1] = new PdfHozonBean();
                pdfHozonBeans[iI - 1].setPdfData(baos.toByteArray());
            } catch (Exception e1) {
                throw new BizAppException(e1, "EAS0014");
            }
        }
        return pdfHozonBeans;
    }

    public static void mask(PdfWriter poWriter, MaskInfoBean[] poBeans) {
        PdfContentByte oContentByte = poWriter.getDirectContent();

        for (int iI = 0; iI < poBeans.length; iI++) {
            oContentByte.setLineWidth(poBeans[iI].getWeight());
            oContentByte.moveTo(poBeans[iI].getStartX(), poBeans[iI].getStartY());
            oContentByte.lineTo(poBeans[iI].getEndX(), poBeans[iI].getStartY());
            oContentByte.stroke();
        }
    }

    @SuppressWarnings("deprecation")
    public static void encrypt(PdfReader poReader, OutputStream poOut) {
        byte[] btUserPass  = new byte[0];
        byte[] btOwnerPass = new byte[0];
        int    iAllow      = 0;

        EncryptInfoConfig encryptInfoConfig = ReportConfig.getInstance().getEncryptInfoConfig();

        if (encryptInfoConfig.getUserPassword() != null) {
            btUserPass = encryptInfoConfig.getUserPassword().getBytes();
        }
        if (encryptInfoConfig.getOwnerPassword() != null) {
            btOwnerPass = encryptInfoConfig.getOwnerPassword().getBytes();
        }
        if (!encryptInfoConfig.isPrint()) {
            iAllow |= PdfWriter.AllowPrinting;
        }
        if (!encryptInfoConfig.isContents()) {
            iAllow |= PdfWriter.AllowModifyContents;
        }
        if (!encryptInfoConfig.isCopy()) {
            iAllow |= PdfWriter.AllowCopy;
        }
        if (!encryptInfoConfig.isNotesAndField()) {
            iAllow |= PdfWriter.AllowModifyAnnotations;
        }

        try{
            PdfEncryptor.encrypt(poReader, poOut, btUserPass, btOwnerPass, iAllow, true);
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0006");
        }
    }
}
