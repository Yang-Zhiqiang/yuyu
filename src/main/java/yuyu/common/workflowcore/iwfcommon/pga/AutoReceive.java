package yuyu.common.workflowcore.iwfcommon.pga;

import java.util.List;

import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.context.MessageContext;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfPDFUtils;
import yuyu.common.workflowcore.iwfcommon.check.Checks;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 自動受信。
 */
public class AutoReceive {

    private static final String sLPGA_QR_CODE_VALUE = "qrCodeValue";

    private static final String sLPGA_DOCUMENT_URI = "documentURI";

    private static final String sLPGA_USER = "user";

    private static final String sLPGA_PAGES = "pages";

    private String sLpgaPrefix_ = "";

    public AutoReceive() throws Exception {
        super();
        sLpgaPrefix_ = AutoReceiveConfig.getProperty("iwf.webservice.soap.pga.serviceroot", "http://localhost:8080/lpga/ws/");
    }

    public void exec() throws Exception {

        initialize();

        try {

            mainLogic();

        } catch (Exception e) {

            throw e;

        } finally {

            terminate();
        }

    }

    private void initialize() {
    }

    private void mainLogic() throws Exception {

        String sDocpageId    = "";
        OMElement oParam     = null;
        String sDocumentid   = "";
        String sDocumentURI  = "";
        String sKosid        = "";
        int iPages           = 0;

        MessageContext oContext = MessageContext.getCurrentMessageContext();
        SOAPEnvelope oEnvelope = oContext.getEnvelope();
        SOAPBody oBody = oEnvelope.getBody();
        OMElement oElement = oBody.getFirstElement();

        try {
            @SuppressWarnings("unchecked")
            List<OMElement> oOMElements = Lists.newArrayList(oElement.getChildElements());
            for(OMElement oOMElement : oOMElements){
                if (sLPGA_QR_CODE_VALUE.equals(oOMElement.getLocalName())) {
                    String sQrCodeValue = oOMElement.getText();
                    if (sQrCodeValue.startsWith(sLpgaPrefix_)) {
                        sDocumentid = sQrCodeValue.substring(sLpgaPrefix_.length());
                    } else {
                        throw new Exception();
                    }
                } else if (sLPGA_DOCUMENT_URI.equals(oOMElement.getLocalName())) {
                    sDocumentURI = oOMElement.getText();
                } else if (sLPGA_USER.equals(oOMElement.getLocalName())) {
                    sKosid = oOMElement.getText();
                } else if (sLPGA_PAGES.equals(oOMElement.getLocalName())) {
                    iPages = Integer.parseInt(oOMElement.getText());
                }
            }

            PGAControl oPga = new PGAControl(sDocumentURI);
            byte[] btDatas = oPga.receive();

            PdfPage[] oBeans = IwfPDFUtils.split(new PdfReader(btDatas));

            if (oBeans.length > 0) {

                String sSyoruittykymdtime = IwfDateUtils.getSysDate();

                String sTorikomisyoruicd = null;
                String sGyoumukey        = null;
                String kosid             = null;


                for(PdfPage page : oBeans){
                    String pageid = UniqueKeyGenerator.UNIQUE_KEY;

                    String imageid = page.getS_imageid();
                    kosid = page.getS_kosid();
                    String kostime = page.getS_kostime();

                }

                String sFlowid = null;
                if(Checks.checkCanKouteikaisiByTorikomisyoruiCd(sTorikomisyoruicd)){

                    IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();
                    oWfCtx.open();

                }else{

                }

                oPga.delete();
            }
        } finally {
            oContext.getTransportOut().getSender().cleanup(oContext);
        }
    }

    private void terminate() {
    }
}
