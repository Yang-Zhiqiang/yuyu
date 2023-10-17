package yuyu.app.biz.bzfiledl.bzfiledownload;

import static yuyu.app.biz.bzfiledl.bzfiledownload.BzFileDownloadConstants.*;
import static yuyu.app.biz.bzfiledl.bzfiledownload.GenBzFileDownloadConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * ファイルダウンロード 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzfiledl/bzfiledownload/BzFileDownload.do", redirect=true),
    @Forward(name=FORWARDNAME_INIT_IPPANJIMUBUMONYOU,     page=PAGENO_INIT_IPPANJIMUBUMONYOU,     path="/biz/bzfiledl/bzfiledownload/BzFileDownload.do?_eventHandler=initIppanjimubumonyou", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzfiledl/bzfiledownload/bz_file_download.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzfiledl/bzfiledownload/bz_file_download.jsp"),
    @Forward(name=FORWARDNAME_DOWNLOAD, page=PAGENO_DOWNLOAD, path="/biz/bzfiledl/bzfiledownload/bz_file_download.jsp"),
    @Forward(name=FORWARDNAME_OUTPUTKENGENERROR, page=PAGENO_OUTPUTKENGENERROR, path="/biz/bzfiledl/bzfiledownload/bz_file_download.jsp"),
})
@Input("/biz/bzfiledl/bzfiledownload/bz_file_download.jsp")
@UIBean(beanClass=BzFileDownloadUiBean.class)
@Roles({"bzfiledownload", "bzfiledownloadippanjimubumonyou"})
public class BzFileDownloadAction {

    @Inject
    private BzFileDownloadBizLogic bizLogic;

    @Begin
    public String init() {

        String transitionName = bizLogic.init();
        if (transitionName.equals(BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR)) {
            return FORWARDNAME_OUTPUTKENGENERROR;
        }

        return FORWARDNAME_INPUTKEY;
    }

    @Begin
    public String initIppanjimubumonyou() {

        String transitionName = bizLogic.initIppanjimubumonyou();
        if (transitionName.equals(BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR)) {
            return FORWARDNAME_OUTPUTKENGENERROR;
        }

        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String fileNmOnClick() {
        bizLogic.pushFileNmBL();
        return FORWARDNAME_CURRENT;
    }

    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_DOWNLOAD;
    }

    @End
    public String modorubtnOnClick() {

        String senisaki = bizLogic.getSenisaki();
        return senisaki;
    }

    public String fileInfoListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public void downloadFile(){
        bizLogic.downloadFile();
    }

    @End
    public String functionNameOnClick() {

        String senisaki = bizLogic.getSenisaki();
        return senisaki;
    }

}
