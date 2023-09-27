package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.direct.dscommon.dba4genkyoutuutikaripasswordhakkou.DsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean;
import yuyu.common.direct.dscommon.dba4genkyoutuutikaripasswordhakkou.GenkyouTuutiKariPasswordHakkouDao;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrPswdGnkTtStrkHnCdKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.direct.configuration.YuyuDirectConfig;
import yuyu.def.direct.manager.DirectDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 現況通知用仮パスワード発行
 */
public class GenkyouTuutiKariPasswordHakkou {

    @Inject
    private static Logger logger;

    @Inject
    private GenkyouTuutiKariPasswordHakkouDao genkyouTuutiKariPasswordHakkouDao;

    @Inject
    private DirectDomManager directDomManager;

    public GenkyouTuutiKariPasswordHakkou() {
        super();
    }

    public GenkyouTuutiyouKariPasswordBean exec(String pSyoNo, BizDate pSyoriYmd) {

        logger.debug("▽ 現況通知用仮パスワード発行 開始");

        String syoNo = pSyoNo;
        BizDate syoriYmd = pSyoriYmd;
        String dsKrHnnKakCd = "";
        String zenkaiDsKrHnnKakCd = "";
        BizDate dsKrHnnKakCdYuukouYmd = null;
        C_MukouHyj dsKykMukouHyj = null;
        C_DsKokyakuJtKbn dsKokyakuJtKbn = null;
        C_DsTeisiRiyuuKbn dsTeisiRiyuuKbn = null;
        C_DsKrHnnKakCdSetKbn dsKrHnnKakCdSetKbn = null;
        BizDate dsKokyakuSeiYmd = null;
        String tsintelNo = "";
        C_IdoutyuuHanteiKekkaKbn idoutyuuHanteiKekkaKbn = null;
        BizDate yuukouKigenHanteiKyoukaiYmd = null;
        String genkyouTuutiKariPassword = "";
        String genkyouTuutiKariPasswordYoken = "";

        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean =
            SWAKInjector.getInstance(GenkyouTuutiyouKariPasswordBean.class);

        DsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean
        dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean =
        genkyouTuutiKariPasswordHakkouDao.
        getDsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUM(syoNo);

        if (dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean == null) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.NONE);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.DSMIKANYUU);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;

        }
        dsKrHnnKakCd = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.getDskrhnnkakcd();

        zenkaiDsKrHnnKakCd = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.
            getZenkaidskrhnnkakcd();

        dsKrHnnKakCdYuukouYmd = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.
            getDskrhnnkakcdyuukouymd();

        dsKykMukouHyj = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.getDskykmukouhyj();

        dsKokyakuJtKbn = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.getDskokyakujtkbn();

        dsTeisiRiyuuKbn = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean
            .getDsteisiriyuukbn();

        dsKrHnnKakCdSetKbn = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.
            getDskrhnnkakcdsetkbn();

        dsKokyakuSeiYmd = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.
            getDskokyakuseiymd();

        tsintelNo = dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.
            getTsintelno();

        if (dsKykMukouHyj == null || dsKokyakuJtKbn == null ||
            dsTeisiRiyuuKbn == null || dsKrHnnKakCdSetKbn == null || dsKokyakuSeiYmd == null
            || BizUtil.isBlank(tsintelNo)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.ERROR);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(null);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;

        }

        if (C_MukouHyj.MUKOU.eq(dsKykMukouHyj)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.NONE);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.DSKAIYAKU);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(
            dsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.getDskokno());

        dsKokyakuKanri = genkyouTuutiKariPasswordHakkouDao.detachDsTorihikiServiceKanri(dsKokyakuKanri);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(pSyoNo);

        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

        if (dsTorihikiServiceKanri != null) {
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);

        } else {
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);

        }

        HozenKeiyakuIdouJyoutaiSyutoku keiyakuIdouJyoutaiSyutoku = SWAKInjector.getInstance(
            HozenKeiyakuIdouJyoutaiSyutoku.class);

        HozenKeiyakuIdouJyoutaiSyutokuBean keiyakuIdouJyoutaiSyutokuBean = keiyakuIdouJyoutaiSyutoku.
            hozenKeiyakuIdouJyoutaiSyutoku(syoNo);
        idoutyuuHanteiKekkaKbn = keiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn();

        if (C_IdoutyuuHanteiKekkaKbn.ERROR.eq(idoutyuuHanteiKekkaKbn)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.ERROR);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(null);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(idoutyuuHanteiKekkaKbn)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.IDOUSYORITYUU);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }

        if (C_DsKokyakuJtKbn.YUUKOU.eq(dsKokyakuJtKbn)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean
            .setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.HONPASSWORDTOUROKUZUMI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(dsKokyakuJtKbn)) {
        }
        else {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.ERROR);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(null);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }

        if (C_DsTeisiRiyuuKbn.LOCK_OUT.eq(dsTeisiRiyuuKbn)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.LOCKOUTTYUU);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else if (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(dsTeisiRiyuuKbn) || C_DsTeisiRiyuuKbn.SONOTA.eq(dsTeisiRiyuuKbn)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.SERVICETEISITYUU);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else if (C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU.eq(dsTeisiRiyuuKbn)) {

        }
        else {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.ERROR);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(null);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }

        if (C_DsKrHnnKakCdSetKbn.SAIHAKKOU.eq(dsKrHnnKakCdSetKbn)) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean
            .setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.SAIHAKKOUSEIKYUUZUMI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else if (C_DsKrHnnKakCdSetKbn.SINKI.eq(dsKrHnnKakCdSetKbn)) {

        }
        else {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.ERROR);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(null);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }

        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        Integer tuutiKanouYuukouKikan = config.getGenkyoutuutiKrpasswordtuutiKanouYuukouKikan();
        yuukouKigenHanteiKyoukaiYmd = syoriYmd.addMonths(tuutiKanouYuukouKikan).getRekijyou();

        if (dsKrHnnKakCdYuukouYmd == null) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.KRPASSWORDMIHAKKOU);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else if (BizDateUtil.compareYmd(dsKrHnnKakCdYuukouYmd, yuukouKigenHanteiKyoukaiYmd)
            == BizDateUtil.COMPARE_GREATER) {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }
        else {

            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtkahikbn(C_KahiKbn.HUKA);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.ZANZONKIKANSUKUNAI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdYoken("");
            genkyouTuutiyouKariPasswordBean.setDsKrPswdyuukouymd(null);

            logger.debug("△ 現況通知用仮パスワード発行 終了");

            return genkyouTuutiyouKariPasswordBean;
        }

    }

}
