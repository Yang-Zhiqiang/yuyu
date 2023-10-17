package yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetuKbn;

/**
 * 不備メッセージ のビジネスロジックです。
 */
public class SkHubiMsgBizLogic {

    @Inject
    private SkHubiMsgUiBean uiBean;

    @Inject
    private MessageManager messageMgr;

    @Inject
    private ObjStorageManager objStrMan;

    void init() {
    }

    void clear() {
    }

    void doOpen() {

        BizPropertyInitializer.initialize(uiBean);

        String uniqueId = uiBean.getUniqueId();
        SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo = objStrMan.retrieve(uniqueId);
        uniqueId = objStrMan.save(skHubiMsgRenkeiInfo);
        uiBean.setUniqueId(uniqueId);

        List<KetteiHoryuuHubiDataSourceBean> ketteihoryuhubiLst = new ArrayList<>();
        List<SeirituHoryuuHubiDataSourceBean> seirituhoryuhubiLst = new ArrayList<>();
        List<WarningDataSourceBean> warningLst = new ArrayList<>();
        List<KihonHubiDataSourceBean> kihonhubiLst = new ArrayList<>();


        List<String> hubimsgDataLst = skHubiMsgRenkeiInfo.getHubimsgData();
        for (int i = 0; i < hubimsgDataLst.size(); i++) {
            String[] tmpDatas = hubimsgDataLst.get(i).trim().split(" ", 3);
            String msgSyubetu = tmpDatas[0];

            if (C_HubisyubetuKbn.KETHORYU_HUBI.getValue().equals(msgSyubetu) ) {
                KetteiHoryuuHubiDataSourceBean ketteiHoryuuHubiDataSourceBean = new KetteiHoryuuHubiDataSourceBean();
                ketteiHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                ketteiHoryuuHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                ketteihoryuhubiLst.add(ketteiHoryuuHubiDataSourceBean);
            }
            else if (C_HubisyubetuKbn.SRHORYU_HUBI.getValue().equals(msgSyubetu) ) {
                SeirituHoryuuHubiDataSourceBean seirituHoryuuHubiDataSourceBean = new SeirituHoryuuHubiDataSourceBean();
                seirituHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                seirituHoryuuHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                seirituhoryuhubiLst.add(seirituHoryuuHubiDataSourceBean);
            }
            else if (C_HubisyubetuKbn.WARNING.getValue().equals(msgSyubetu) ) {
                WarningDataSourceBean warningDataSourceBean = new WarningDataSourceBean();
                warningDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                warningDataSourceBean.setDisphubimsg(tmpDatas[2]);

                warningLst.add(warningDataSourceBean);
            }
            else if (C_HubisyubetuKbn.KIHON_HUBI.getValue().equals(msgSyubetu) ) {
                KihonHubiDataSourceBean kihonHubiDataSourceBean = new KihonHubiDataSourceBean();
                kihonHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                kihonHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                kihonhubiLst.add(kihonHubiDataSourceBean);
            }
        }

        uiBean.setMosno(skHubiMsgRenkeiInfo.getMosno());
        uiBean.setHhknnmkj(skHubiMsgRenkeiInfo.getHhknnmkj());
        uiBean.setKetteiHoryuuHubi(ketteihoryuhubiLst);
        uiBean.setSeirituHoryuuHubi(seirituhoryuhubiLst);
        uiBean.setWarning(warningLst);
        uiBean.setKihonHubi(kihonhubiLst);

        messageMgr.addMessageId(MessageId.IHA0010);
    }

    void removeObj() {
        objStrMan.remove(uiBean.getUniqueId());
    }
}
