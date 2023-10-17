package yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.objstorage.ObjStorageManager;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;

/**
 * 入力差異照会 のビジネスロジックです。
 */
public class SkNyuuryokuSaiSyoukaiBizLogic {

    @Inject
    private SkNyuuryokuSaiSyoukaiUiBean uiBean;

    @Inject
    private ObjStorageManager objStrMan;

    void init() {
    }

    void clear() {
    }

    void doOpen() {

        BizPropertyInitializer.initialize(uiBean);

        String uniqueId = uiBean.getUniqueId();
        SkNyuuryokuSaiSyoukaiRenkeiInfo skNyuuryokuSaiSyoukaiRenkeiInfo = objStrMan.retrieve(uniqueId);
        uniqueId = objStrMan.save(skNyuuryokuSaiSyoukaiRenkeiInfo);
        uiBean.setUniqueId(uniqueId);

        List<NyuuryokuSouiListDataSourceBean> nyuuryokuSouiListDataSourceBeanLst = new ArrayList<>();

        String[] nrkSouiKm = skNyuuryokuSaiSyoukaiRenkeiInfo.getNrksouikm();
        String[] itijiRk = skNyuuryokuSaiSyoukaiRenkeiInfo.getItijinrk();
        String[] nijinrk = skNyuuryokuSaiSyoukaiRenkeiInfo.getNijinrk();

        for (int i = 0; i < nrkSouiKm.length; i++) {
            NyuuryokuSouiListDataSourceBean nyuuryokuSouiListDataSourceBean = new NyuuryokuSouiListDataSourceBean();
            nyuuryokuSouiListDataSourceBean.setDispnrksouikm(nrkSouiKm[i]);
            nyuuryokuSouiListDataSourceBean.setDispitijinrk(itijiRk[i]);
            nyuuryokuSouiListDataSourceBean.setDispnijinrk(nijinrk[i]);

            nyuuryokuSouiListDataSourceBeanLst.add(nyuuryokuSouiListDataSourceBean);
        }

        uiBean.setMosno(skNyuuryokuSaiSyoukaiRenkeiInfo.getMosno());
        uiBean.setAitemosno(skNyuuryokuSaiSyoukaiRenkeiInfo.getAitemosno());
        uiBean.setNyuuryokuSouiList(nyuuryokuSouiListDataSourceBeanLst);
    }

    void removeObj() {
        objStrMan.remove(uiBean.getUniqueId());
    }
}
