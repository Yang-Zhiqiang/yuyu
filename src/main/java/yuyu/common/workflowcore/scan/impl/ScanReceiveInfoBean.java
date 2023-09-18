package yuyu.common.workflowcore.scan.impl;

import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;

/**
 * スキャナーから送られてきたデータを格納するBeanクラスです。<br />
 */
@ThreadScoped
public class ScanReceiveInfoBean{

    private String documentId;
    private String documentURI;
    private String userId;
    private int    pages;

    public String getDocumentId(){
        return documentId;
    }

    void setDocumentId(String documentId){
        this.documentId = documentId;
    }

    public String getDocumentURI(){
        return documentURI;
    }

    void setDocumentURI(String documentURI){
        this.documentURI = documentURI;
    }

    public String getUserId(){
        return userId;
    }

    void setUserId(String userId){
        this.userId = userId;
    }

    public int getPages(){
        return pages;
    }

    void setPages(int pages){
        this.pages = pages;
    }
}
