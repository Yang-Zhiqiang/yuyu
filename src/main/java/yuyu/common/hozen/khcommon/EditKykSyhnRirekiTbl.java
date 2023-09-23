package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 契約商品履歴TBL編集
 */
public class EditKykSyhnRirekiTbl {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    public EditKykSyhnRirekiTbl() {
        super();
    }

    public void exec(KhozenCommonParam pKCParm, String pSyoNo, C_SyutkKbn pSyuTkKbn,
        String pSyouhnCd, int pSyouhnSdNo, int pSyouhnRenNo ) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
            pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo);
        if (kykSyouhn != null) {
            IT_KykSyouhnRireki kykSyouhnRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(
                kykSyouhn.getHenkousikibetukey()).createKykSyouhnRireki();
            BeanUtil.copyProperties(kykSyouhnRireki, kykSyouhn);
            BizPropertyInitializer.initialize(kykSyouhnRireki);
        }

        IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
            pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo);
        if (syouhnTokujou != null) {
            IT_SyouhnTokujouRireki syouhnTokujouRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(
                syouhnTokujou.getHenkousikibetukey()).createSyouhnTokujouRireki();
            BeanUtil.copyProperties(syouhnTokujouRireki, syouhnTokujou);
            BizPropertyInitializer.initialize(syouhnTokujouRireki);
        }

        hozenDomManager.update(kykKihon);

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約商品履歴TBL、商品特条履歴TBL編集");
            logger.debug("｜ 証券番号         = [" + pSyoNo               + "]");
            logger.debug("｜ 主契約特約区分   = [" + pSyuTkKbn            + "]");
            logger.debug("｜ 商品コード       = [" + pSyouhnCd            + "]");
            logger.debug("｜ 商品世代番号     = [" + pSyouhnSdNo          + "]");
            logger.debug("｜ 契約商品連番     = [" + pSyouhnRenNo         + "]");
            logger.debug("｜ ▽ 契約保全共通パラメータ");
            logger.debug("｜ ｜ 機能ID        = [" + pKCParm.getFunctionId()  + "]");
            logger.debug("｜ ｜ ユーザID      = [" + pKCParm.getUserID()      + "]");
            logger.debug("｜ △");
            logger.debug("△");
        }

    }

    public void exec(KhozenCommonParam pKCParm, String pSyoNo) {

        C_KinouKbn kinouKbn = kinou.getKinouKbn();

        IT_KykKihon kykKihon = null;

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        }
        else {

            kykKihon = pKCParm.getBatchKeiyakuKihon();
        }

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        if (kykSyouhnLst != null && kykSyouhnLst.size() > 0) {
            for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {
                String sikibetuKey = kykSyouhn.getHenkousikibetukey();
                IT_KykSyouhnRireki kykSyouhnRireki =
                    kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).createKykSyouhnRireki();
                BeanUtil.copyProperties(kykSyouhnRireki, kykSyouhn);
                BizPropertyInitializer.initialize(kykSyouhnRireki);
            }
        }

        List<IT_SyouhnTokujou> syouhnTokujouLst = kykKihon.getSyouhnTokujous();
        if (syouhnTokujouLst != null && syouhnTokujouLst.size() > 0) {
            for (IT_SyouhnTokujou syouhnTokujou : syouhnTokujouLst) {
                String sikibetuKey = syouhnTokujou.getHenkousikibetukey();
                IT_SyouhnTokujouRireki syouhnTokujouRireki =
                    kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).createSyouhnTokujouRireki();
                BeanUtil.copyProperties(syouhnTokujouRireki, syouhnTokujou);
                BizPropertyInitializer.initialize(syouhnTokujouRireki);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約商品履歴TBL編集");
            logger.debug("｜ 証券番号         = [" + pSyoNo               + "]");
            logger.debug("｜ ▽ 契約保全共通パラメータ");
            logger.debug("｜ ｜ 機能ID        = [" + pKCParm.getFunctionId()  + "]");
            logger.debug("｜ ｜ ユーザID      = [" + pKCParm.getUserID()      + "]");
            logger.debug("｜ △");
            logger.debug("△");
        }

    }

    public void exec(KhozenCommonParam pKCParm,
        String pSyoNo,
        C_SyutkKbn pSyuTkKbn,
        String pSyouhnCd,
        int pSyouhnSdNo,
        int pSyouhnRenNo,
        C_Syoumetujiyuu pSyoumetuJiyuu,
        BizDate pSyoumetuYmd,
        BizDate pKouryokuhasseiYmd) {

        this.exec(pKCParm, pSyoNo, pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo);

        String sikibetuKey = pKCParm.getSikibetuKey(pSyoNo);
        String functionID = pKCParm.getFunctionId();
        String userId = pKCParm.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
            pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo);
        if (kykSyouhn == null) {
            throw new CommonBizAppException("契約商品TBLにデータが存在しません。 証券番号＝" + pSyoNo );
        }

        IT_KykSyouhnRireki kykSyouhnRireki =
            kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).createKykSyouhnRireki();
        BeanUtil.copyProperties(kykSyouhnRireki, kykSyouhn);

        kykSyouhnRireki.setHenkousikibetukey(sikibetuKey);
        kykSyouhnRireki.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhnRireki.setSyoumetujiyuu(pSyoumetuJiyuu);
        kykSyouhnRireki.setSyoumetuymd(pSyoumetuYmd);
        kykSyouhnRireki.setKouryokuhasseiymd(pKouryokuhasseiYmd);
        kykSyouhnRireki.setGyoumuKousinKinou(functionID);
        kykSyouhnRireki.setGyoumuKousinsyaId(userId);
        kykSyouhnRireki.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(kykSyouhnRireki);

        IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
            pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo);
        if (syouhnTokujou != null) {
            IT_SyouhnTokujouRireki syouhnTokujouRireki =
                kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).createSyouhnTokujouRireki();
            BeanUtil.copyProperties(syouhnTokujouRireki, syouhnTokujou);

            syouhnTokujouRireki.setHenkousikibetukey(sikibetuKey);
            syouhnTokujouRireki.setGyoumuKousinKinou(functionID);
            syouhnTokujouRireki.setGyoumuKousinsyaId(userId);
            syouhnTokujouRireki.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(syouhnTokujouRireki);
        }

        hozenDomManager.update(kykKihon);

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約商品履歴TBL、商品特条履歴TBL編集");
            logger.debug("｜ 証券番号         = [" + pSyoNo               + "]");
            logger.debug("｜ 主契約特約区分   = [" + pSyuTkKbn            + "]");
            logger.debug("｜ 商品コード       = [" + pSyouhnCd            + "]");
            logger.debug("｜ 商品世代番号     = [" + pSyouhnSdNo          + "]");
            logger.debug("｜ 契約商品連番     = [" + pSyouhnRenNo         + "]");
            logger.debug("｜ 消滅事由         = [" + pSyoumetuJiyuu       + "]");
            logger.debug("｜ 消滅日           = [" + pSyoumetuYmd         + "]");
            logger.debug("｜ 効力発生日           = [" + pKouryokuhasseiYmd         + "]");
            logger.debug("｜ 識別キー         = [" + sikibetuKey          + "]");
            logger.debug("｜ ▽ 契約保全共通パラメータ");
            logger.debug("｜ ｜ 機能ID        = [" + pKCParm.getFunctionId()  + "]");
            logger.debug("｜ ｜ ユーザID      = [" + pKCParm.getUserID()      + "]");
            logger.debug("｜ △");
            logger.debug("△");
        }
    }
}
