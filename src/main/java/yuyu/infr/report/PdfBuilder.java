package yuyu.infr.report;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.SimpleBookmark;

/**
 * PDFの要素を受け取り、内部保持するクラスです。
 * StringBuilderのPDF版です。
 */
public class PdfBuilder implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final String MAPKEY = "key";

    private boolean convertFlg = true;

    private Map<String, List<PdfReader>> binaryMap = new HashMap<String, List<PdfReader>>();

    private List<String> sortKeyList = new ArrayList<String>();

    private byte[] pdfBinary = null;

    public void append(PdfReader poReader) {

        append(poReader, MAPKEY);
    }

    public void append(PdfReader poReader, String sSortkey) {

        convertFlg = false;

        List<PdfReader> pdfReaderList = binaryMap.get(sSortkey);
        if(pdfReaderList ==null){
            pdfReaderList = new ArrayList<PdfReader>();
            binaryMap.put(sSortkey, pdfReaderList);
        }

        pdfReaderList.add(poReader);

        if(sortKeyList.contains(sSortkey) == false){
            sortKeyList.add(sSortkey);
        }
    }

    public void sort(String[] psSortKeys) {

        convertFlg = false;

        List<String> list = new ArrayList<String>();

        for(int i = 0; i < psSortKeys.length; i++){

            if(sortKeyList.contains(psSortKeys[i])){
                list.add(psSortKeys[i]);
            }
        }

        for(int i = 0; i < sortKeyList.size(); i++){

            if(list.contains(sortKeyList.get(i)) == false){
                list.add(sortKeyList.get(i));
            }
        }

        sortKeyList = list;
    }

    public byte[] toByteArray() {

        if(convertFlg == false){
            convert();
        }

        return pdfBinary;
    }

    @SuppressWarnings({ "unchecked", "rawtypes", "resource" })
    void convert() {

        Document              document  = null;
        PdfCopy               writer    = null;
        ArrayList             bookMarks = new ArrayList();

        int outPages = 0;
        int count    = 0;

        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
                ) {

            Iterator<String> outIt = sortKeyList.iterator();

            while(outIt.hasNext()){

                String sKey = outIt.next();

                List<PdfReader> oList = binaryMap.get(sKey);

                Iterator<PdfReader> inIt = oList.iterator();

                while(inIt.hasNext()){

                    PdfReader pdfr = inIt.next();

                    try {
                        pdfr.consolidateNamedDestinations();

                        int inPages = pdfr.getNumberOfPages();

                        List bookmarkList = SimpleBookmark.getBookmark(pdfr);
                        if (bookmarkList != null) {
                            if (count != 0) {
                                SimpleBookmark.shiftPageNumbers(bookmarkList, outPages, null);
                            }
                            bookMarks.addAll(bookmarkList);
                        }
                        outPages = outPages + inPages;

                        if (count == 0) {
                            document = new Document(pdfr.getPageSizeWithRotation(1));
                            writer   = new PdfCopy(document, baos);
                            document.open();
                        }

                        PdfImportedPage page = null;
                        for (int iI = 1; iI <= inPages; iI++) {
                            if(null != writer){
                                page = writer.getImportedPage(pdfr, iI);
                                writer.addPage(page);
                            }
                        }
                        count++;
                    }
                    catch (Exception e1) {
                        throw new BizAppException(e1, "EAS0016");
                    }
                }
            }
            if (bookMarks.size() > 0) {
                if(null != writer){
                    writer.setOutlines(bookMarks);
                }
            }

            if(null != writer){
                writer.flush();
            }
            if(null != document){
                document.close();
            }

            pdfBinary = baos.toByteArray();
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0007");
        }

        convertFlg = true;
    }
}
