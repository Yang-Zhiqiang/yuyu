package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage;


public interface WSPutImage {

    abstract WSPutImageResponse executeBizMain(WSPutImageRequest request) throws Exception;
}