package yuyu.common.workflowcore.iwfcommon.pga;

import java.io.ByteArrayOutputStream;

import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryFault;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub.DeleteDocument;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub.DeleteDocument0;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub.GetDocument;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub.GetDocument2;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub.GetDocumentResponse;
import jp.co.fujixerox.www._2009._10.pga.ws.lpga.RepositoryServiceStub.GetDocumentResponse3;

/**
 * リポジトリ取得制御。
 */
public class PGAControl {

    private static final String sSERVICE_NAME = "Repository";

    private String sLpgaServiceRoot_ = "";

    private RepositoryServiceStub oStub_ = null;

    private String sDocumentURI_ = null;

    public PGAControl(String psDocumentURI) throws Exception {

        sLpgaServiceRoot_ = "サービスルート";

        oStub_ = new RepositoryServiceStub(sLpgaServiceRoot_ + sSERVICE_NAME);
        sDocumentURI_ = psDocumentURI;
    }

    public byte[] receive() throws Exception {
        ByteArrayOutputStream oBaos = new ByteArrayOutputStream();

        try {
            GetDocument oParam = new GetDocument();
            GetDocument2 oRequest = new GetDocument2();

            GetDocumentResponse3 oResponse = null;
            GetDocumentResponse oResult = null;

            return oBaos.toByteArray();
        }
        finally {
            oStub_.cleanup();
            oBaos.flush();
            oBaos.close();
        }
    }

    public void delete() throws Exception {
        try {
            DeleteDocument oParam = new DeleteDocument();
            DeleteDocument0 oRequest = new DeleteDocument0();

            oStub_.deleteDocument(oRequest);
        }
        catch (RepositoryFault e1) {
            throw e1;
        }
        finally {
            oStub_.cleanup();
        }
    }

}
