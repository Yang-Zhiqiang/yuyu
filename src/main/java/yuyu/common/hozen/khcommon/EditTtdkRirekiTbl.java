package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 手続履歴TBL編集
 */
public class EditTtdkRirekiTbl {

    @Inject
    private EditKhHenkouRirekiTbl editKhHenkouRirekiTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    public EditTtdkRirekiTbl()  {
        super();
    }

    public void exec(EditTtdkRirekiTblParam pRirekiTblParam) {

        pRirekiTblParam.debug();

        KhozenCommonParam khozenCommonParam = pRirekiTblParam.getCommonParam();
        String syoNo = pRirekiTblParam.getSyoNo();
        String sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);
        C_UmuKbn henkouRrkUm = C_UmuKbn.NONE ;
        String syorisosikiCd = khozenCommonParam.getTmSosikiCd();
        IT_NyuukinKakusyouData nyuukinKakusyouData = pRirekiTblParam.getNyuukinKakusyouData();

        IT_KykKihon kykKihon = new IT_KykKihon();
        IT_AnsyuKihon ansyuKihon = new IT_AnsyuKihon();
        C_KinouKbn kinouKbn = kinou.getKinouKbn();
        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            kykKihon = hozenDomManager.getKykKihon(syoNo);

            ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        }
        else {

            kykKihon = khozenCommonParam.getBatchKeiyakuKihon();

            ansyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        }

        if(C_YouhiKbn.YOU.eq(pRirekiTblParam.getHenkouRrkYouhi())) {

            IT_BAK_KykKihon bak_KykKihon = new IT_BAK_KykKihon();
            IT_BAK_AnsyuKihon bak_AnsyuKihon = new IT_BAK_AnsyuKihon();

            if (C_KinouKbn.ONLINE.eq(kinouKbn)) {
                bak_KykKihon = hozenDomManager.getBAKKykKihon(syoNo, sikibetuKey);
                bak_AnsyuKihon = hozenDomManager.getBAKAnsyuKihon(syoNo, sikibetuKey);
            }
            else {

                bak_KykKihon = khozenCommonParam.getBatchBakKykKihon();
                bak_AnsyuKihon = khozenCommonParam.getBatchBakAnsyuKihon();
            }

            List<IT_KhHenkouRireki> khHenkouRirekiLst = editKhHenkouRirekiTbl.exec(
                kykKihon,
                bak_KykKihon,
                ansyuKihon,
                bak_AnsyuKihon,
                nyuukinKakusyouData,
                sikibetuKey);

            if (khHenkouRirekiLst.size() != 0) {
                henkouRrkUm = C_UmuKbn.ARI;
            }
        }

        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey);

        khTtdkRireki.setHenkousikibetukey(sikibetuKey);
        khTtdkRireki.setSyoriYmd(pRirekiTblParam.getSyoriYmd());
        khTtdkRireki.setSyorisosikicd(syorisosikiCd);
        khTtdkRireki.setShrsyousaiumu(pRirekiTblParam.getShrSyousaiUmu());
        khTtdkRireki.setSyorikbn(pRirekiTblParam.getSyoriKbn());
        khTtdkRireki.setHonninkakninkekkakbn(pRirekiTblParam.getHonninkakkekka());
        khTtdkRireki.setHenkourrkumu(henkouRrkUm);
        khTtdkRireki.setSmbckanriid(pRirekiTblParam.getSmbcKanriId());
        khTtdkRireki.setNayosekihontblskbtkey(pRirekiTblParam.getNayoseKihontblSkbtKey());
        khTtdkRireki.setKouteikanriid(pRirekiTblParam.getKouteiKanriId());
        khTtdkRireki.setYoukyuuno(pRirekiTblParam.getYoukyuuNo());
        khTtdkRireki.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khTtdkRireki.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khTtdkRireki.setGyoumuKousinTime(pRirekiTblParam.getSysTime());
        BizPropertyInitializer.initialize(khTtdkRireki);

        EditSeihowebIdouRirekiTbl editSeihowebIdouRirekiTbl = SWAKInjector.getInstance(EditSeihowebIdouRirekiTbl.class);

        editSeihowebIdouRirekiTbl.exec(pRirekiTblParam.getSyoriYmd(), pRirekiTblParam.getSyoriKbn(),
            khozenCommonParam.getSikibetuKey(syoNo), khozenCommonParam.getFunctionId(), khozenCommonParam.getUserID(),
            pRirekiTblParam.getSysTime(), kykKihon, ansyuKihon);
    }
}
