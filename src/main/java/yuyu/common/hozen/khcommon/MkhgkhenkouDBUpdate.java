package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 目標額変更DB更新
 */
public class MkhgkhenkouDBUpdate {

    private IT_KykKihon kykKihon;

    private IT_KhHenkouUktk khHenkouUktk;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public IT_KhHenkouUktk getKhHenkouUktk() {
        return khHenkouUktk;
    }

    public void exec(MkhgkhenkouDBUpdateBean pMkhgkhenkouDBUpdateBean) {

        logger.debug("▽ 目標額変更DB更新 開始");


        String syono = pMkhgkhenkouDBUpdateBean.getKykKihon().getSyono();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        C_KinouKbn kinouKbn = kinou.getKinouKbn();
        KhozenCommonParam khozenCommonParam = pMkhgkhenkouDBUpdateBean.getKhCommonParam();
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        int targettkMkht;

        if (C_TargetTkMokuhyoutiKbn.NOTARGET.eq(pMkhgkhenkouDBUpdateBean.getTargettkMkhtkbn())) {
            targettkMkht = 0;
        }
        else {
            targettkMkht = Integer.parseInt(pMkhgkhenkouDBUpdateBean.getTargettkMkhtkbn().getValue());
        }



        String sikibetuKey = khozenCommonParam.getSikibetuKey(syono);

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(syono, sikibetuKey);


        IT_KykKihon kykKihonUpd = pMkhgkhenkouDBUpdateBean.getKykKihon();

        kykKihonUpd.setSyhenkouymd(pMkhgkhenkouDBUpdateBean.getSyoriYmd());
        kykKihonUpd.setGyoumuKousinKinou(kinouId);
        kykKihonUpd.setGyoumuKousinsyaId(userId);
        kykKihonUpd.setGyoumuKousinTime(sysDateTime);

        IT_KhTtdkRireki khTtdkRireki = kykKihonUpd.createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihonUpd.getKykSonotaTkyk();

        kykSonotaTkyk.setTargettkykkykhenkoymd(pMkhgkhenkouDBUpdateBean.getTargetTkKykhenkoymd());
        kykSonotaTkyk.setTargettkmokuhyouti(targettkMkht);
        kykSonotaTkyk.setGyoumuKousinKinou(kinouId);
        kykSonotaTkyk.setGyoumuKousinsyaId(userId);
        kykSonotaTkyk.setGyoumuKousinTime(sysDateTime);


        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(syono);
        editTtdkRirekiTblParam.setSyoriYmd(pMkhgkhenkouDBUpdateBean.getSyoriYmd());
        editTtdkRirekiTblParam.setSysTime(sysDateTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {
            editTtdkRirekiTblParam.setHonninkakkekka(pMkhgkhenkouDBUpdateBean.getHonninKakninKekkaKbn());
            editTtdkRirekiTblParam.setKouteiKanriId(pMkhgkhenkouDBUpdateBean.getKouteiKanriId());
        }
        else {
            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

            khozenCommonParam.setBatchKeiyakuKihon(pMkhgkhenkouDBUpdateBean.getKykKihon());
            khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
            khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
            khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());
        }

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);


        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        editTtdkKanryouParam.setTargetTkKbn(kykSonotaTkyk.getTargettkkbn());
        editTtdkKanryouParam.setTargetTkMkhtKbn(pMkhgkhenkouDBUpdateBean.getTargettkMkhtkbn());
        editTtdkKanryouParam.setTargetTkKykHenkouYmd(pMkhgkhenkouDBUpdateBean.getTargetTkKykhenkoymd());
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKHNK);
        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR);

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setHassoukbn(pMkhgkhenkouDBUpdateBean.getHassouKbn());
        khozenTyouhyouCtl.setSyoriYmd(pMkhgkhenkouDBUpdateBean.getSyoriYmd());

        C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR };

        khozenTyouhyouCtl.createTyouhyouTBL(
            pMkhgkhenkouDBUpdateBean.getKhCommonParam(),
            syono,
            syoruiCds,
            C_YouhiKbn.HUYOU);


        IT_KhHenkouUktk khHenkouUktkUpd = pMkhgkhenkouDBUpdateBean.getKhHenkouUktk();

        if (C_KinouKbn.BATCH.eq(kinouKbn)) {

            khHenkouUktkUpd.setUktkjyoutaikbn(C_UktkJyoutaiKbn.SYORIZUMI);
            khHenkouUktkUpd.setGyoumuKousinKinou(kinouId);
            khHenkouUktkUpd.setGyoumuKousinsyaId(userId);
            khHenkouUktkUpd.setGyoumuKousinTime(sysDateTime);
        }


        kykKihon = kykKihonUpd;
        khHenkouUktk = khHenkouUktkUpd;

        logger.debug("△ 目標額変更DB更新 終了");
    }
}
