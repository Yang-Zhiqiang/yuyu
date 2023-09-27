package yuyu.common.direct.dscommon;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_BAK_DsLoginKanri;
import yuyu.def.db.entity.MT_BAK_DsMailAddress;
import yuyu.def.db.entity.MT_BAK_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_BAK_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_BAK_DsTorihikiyouAnsyono;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.direct.manager.DirectDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ手続履歴テーブル編集クラス
 */
public class DsTetudukiRirekiTableEdit {

    private static final String  SYORIKBN_KOKYAKUJYOUHOU= "1";

    private static final String  SYORIKBN_KEIYAKUJYOUHOU = "2";

    private static final String  SYORIKBN_HONNINKAKUNINCD = "3";

    private static final String  SYORIKBN_LOGIN = "4";

    private static final String  SYORIKBN_MAILADDRESS = "5";

    private static final String  SYORIKBN_TORIHIKISERVICEKANRI = "6";

    private static final String  SYORIKBN_SOUKINYOUKOUZA = "7";

    private static final String  SYORIKBN_TORIHIKIYOUANSYONO = "8";

    private static final String HANBETUKOUMOKUNM_DSKOKYAKUKANRI = "ＤＳ顧客管理情報";

    private static final String HANBETUKOUMOKUNM_DSKOKYAKUKEIYAKU = "ＤＳ顧客契約情報　証券番号：";

    private static final String HANBETUKOUMOKUNM_DSHONNINKAKUNINCD = "ＤＳ本人確認コード情報";

    private static final String HANBETUKOUMOKUNM_DSLOGINKANRI = "ＤＳログイン管理情報";

    private static final String HANBETUKOUMOKUNM_DSMAILADDRESS = "ＤＳメールアドレス情報　ＤＳメールアドレス連番：";

    private static final String HANBETUKOUMOKUNM_DSTORIHIKISERVICEKANRI = "ＤＳ取引サービス管理情報　証券番号：";

    private static final String HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_SYONO = "ＤＳ送金用口座情報　証券番号：";

    private static final String HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_KZSYURUIKBN = "ＤＳ送金用口座情報　口座種類区分：";

    private static final String HANBETUKOUMOKUNM_DSTORIHIKIYOUANSYONO = "ＤＳ特定取引用暗証番号情報　証券番号：";

    private static final String HITOKU = "***";

    private int renno = 0;

    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    public DsTetudukiRirekiTableEdit() {
        super();
    }

    public void editDSTtdkRirekiTblOnline(DsTetudukiRirekiTableEditParam pDsTetudukiRirekiTableEditParam) {

        logger.debug("▽ ＤＳ手続履歴テーブル編集 開始");

        renno = 0;

        kinou = SWAKInjector.getInstance(AS_Kinou.class);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(
            pDsTetudukiRirekiTableEditParam.getDskokno());

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = directDomManager.getBAKDsKokyakuKanri(
            pDsTetudukiRirekiTableEditParam.getDskokno(), pDsTetudukiRirekiTableEditParam.getHenkousikibetukey());

        pDsTetudukiRirekiTableEditParam.setDsKokyakuKanri(dsKokyakuKanri);
        pDsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakDsKokyakuKanri);

        editDSTtdkRirekiTblByEntity(pDsTetudukiRirekiTableEditParam);

        logger.debug("△ ＤＳ手続履歴テーブル編集 終了");
    }

    public void editDSTtdkRirekiTblBatch(DsTetudukiRirekiTableEditParam pDsTetudukiRirekiTableEditParam) {

        logger.debug("▽ ＤＳ手続履歴テーブル編集 開始");

        renno = 0;

        kinou = SWAKInjector.getInstance(AS_Kinou.class);

        editDSTtdkRirekiTblByEntity(pDsTetudukiRirekiTableEditParam);

        logger.debug("△ ＤＳ手続履歴テーブル編集 終了");
    }

    public void editDSTtdkRirekiTblWebService(DsTetudukiRirekiTableEditParam pDsTetudukiRirekiTableEditParam,
        AS_Kinou pKinou) {

        logger.debug("▽ ＤＳ手続履歴テーブル編集 開始");

        renno = 0;

        kinou = pKinou;

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(
            pDsTetudukiRirekiTableEditParam.getDskokno());

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = directDomManager.getBAKDsKokyakuKanri(
            pDsTetudukiRirekiTableEditParam.getDskokno(), pDsTetudukiRirekiTableEditParam.getHenkousikibetukey());

        pDsTetudukiRirekiTableEditParam.setDsKokyakuKanri(dsKokyakuKanri);
        pDsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakDsKokyakuKanri);

        editDSTtdkRirekiTblByEntity(pDsTetudukiRirekiTableEditParam);

        logger.debug("△ ＤＳ手続履歴テーブル編集 終了");
    }

    private void editDSTtdkRirekiTblByEntity(DsTetudukiRirekiTableEditParam pDsTetudukiRirekiTableEditParam) {

        String gyoumuKousinKinou = kinou.getKinouId();
        String gyoumuKousinsyaId = baseUserInfo.getUserId();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        if (null == pDsTetudukiRirekiTableEditParam.getDsKokyakuKanri()) {

            throw new BizAppException(MessageId.EBS0004, MT_DsKokyakuKanri.TABLE_NAME, MT_DsKokyakuKanri.DSKOKNO,
                pDsTetudukiRirekiTableEditParam.getDskokno());
        }

        MT_DsKokyakuKanri dsKokyakuKanri = pDsTetudukiRirekiTableEditParam.getDsKokyakuKanri();

        MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri.createDsTtdkRireki();

        dsTtdkRireki.setHenkousikibetukey(pDsTetudukiRirekiTableEditParam.getHenkousikibetukey());

        if (C_YouhiKbn.YOU.eq(pDsTetudukiRirekiTableEditParam.getHenkouRrkYouhi()) ) {

            MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = pDsTetudukiRirekiTableEditParam.getBakDsKokyakuKanri();

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                renno = renno + 1;

                dsHenkouRireki.setRenno(renno);
                dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsKokyakuKanri).getViewName());
                dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsKokyakuKanri).getTableId());
                dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSKOKYAKUKANRI);
                dsHenkouRireki.setHenkoukoumokuid(MT_DsKokyakuKanri.DSKOKNO);
                dsHenkouRireki.setHenkoukoumokunm(
                    ((AbstractExDBEntity<?,?>)dsKokyakuKanri).getFieldViewName(MT_DsKokyakuKanri.DSKOKNO));
                dsHenkouRireki.setNewnaiyou(dsKokyakuKanri.getDskokno());
                dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(dsHenkouRireki);
            }
            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                entityFieldsForCompare(dsKokyakuKanri, bakDsKokyakuKanri,
                    dsTtdkRireki, SYORIKBN_KOKYAKUJYOUHOU, gyoumuKousinTime);
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {

                    MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                    renno = renno + 1;

                    dsHenkouRireki.setRenno(renno);
                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getViewName());
                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getTableId());
                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                    dsHenkouRireki.setHanbetukoumokunm(
                        HANBETUKOUMOKUNM_DSKOKYAKUKEIYAKU.concat(dsKokyakuKeiyaku.getSyono()));
                    dsHenkouRireki.setHenkoukoumokuid(MT_DsKokyakuKeiyaku.SYONO);
                    dsHenkouRireki.setHenkoukoumokunm(
                        ((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getFieldViewName(MT_DsKokyakuKeiyaku.SYONO));
                    dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsKokyakuKeiyaku.getSyono()));
                    dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                    dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                    dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(dsHenkouRireki);
                }
            }
            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_BAK_DsKokyakuKeiyaku> bakDsKokyakuKeiyakuList = bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus();

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_BAK_DsKokyakuKeiyaku bakDsKokyakuKeiyaku : bakDsKokyakuKeiyakuList) {

                    boolean existFlag = false;
                    for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {

                        if (bakDsKokyakuKeiyaku.getSyono().equals(dsKokyakuKeiyaku.getSyono())) {
                            entityFieldsForCompare(dsKokyakuKeiyaku, bakDsKokyakuKeiyaku, dsTtdkRireki
                                , SYORIKBN_KEIYAKUJYOUHOU, gyoumuKousinTime);
                            existFlag = true;
                        }
                    }

                    if (!existFlag) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        MT_DsKokyakuKeiyaku dsKokyakuKeiyakuEnt = new MT_DsKokyakuKeiyaku();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsKokyakuKeiyakuEnt).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsKokyakuKeiyakuEnt).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.SAKUJYO);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSKOKYAKUKEIYAKU.concat(bakDsKokyakuKeiyaku.getSyono()));
                        dsHenkouRireki.setHenkoukoumokuid(MT_DsKokyakuKeiyaku.SYONO);
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsKokyakuKeiyakuEnt).getFieldViewName(MT_DsKokyakuKeiyaku.SYONO));
                        dsHenkouRireki.setBfrnaiyou("証券番号：".concat(bakDsKokyakuKeiyaku.getSyono()));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {

                    boolean existFlag = false;

                    for (MT_BAK_DsKokyakuKeiyaku bakDsKokyakuKeiyaku : bakDsKokyakuKeiyakuList) {

                        if (dsKokyakuKeiyaku.getSyono().equals(bakDsKokyakuKeiyaku.getSyono())) {
                            existFlag = true;
                            break;
                        }
                    }

                    if (!existFlag) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSKOKYAKUKEIYAKU.concat(dsKokyakuKeiyaku.getSyono()));
                        dsHenkouRireki.setHenkoukoumokuid(MT_DsKokyakuKeiyaku.SYONO);
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getFieldViewName(MT_DsKokyakuKeiyaku.SYONO));
                        dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsKokyakuKeiyaku.getSyono()));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

                MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                renno = renno + 1;

                dsHenkouRireki.setRenno(renno);
                dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsHonninKakuninCd).getViewName());
                dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsHonninKakuninCd).getTableId());
                dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSHONNINKAKUNINCD);
                dsHenkouRireki.setHenkoukoumokuid(MT_DsHonninKakuninCd.DSKOKNO);
                dsHenkouRireki.setHenkoukoumokunm(
                    ((AbstractExDBEntity<?,?>)dsHonninKakuninCd).getFieldViewName(MT_DsHonninKakuninCd.DSKOKNO));
                dsHenkouRireki.setNewnaiyou(dsHonninKakuninCd.getDskokno());
                dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(dsHenkouRireki);
            }

            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                MT_BAK_DsHonninKakuninCd bakDsHonninKakuninCd = bakDsKokyakuKanri.getBAKDsHonninKakuninCd();

                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

                entityFieldsForCompare(
                    dsHonninKakuninCd, bakDsHonninKakuninCd, dsTtdkRireki, SYORIKBN_HONNINKAKUNINCD, gyoumuKousinTime);
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

                MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                renno = renno + 1;

                dsHenkouRireki.setRenno(renno);
                dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsLoginKanri).getViewName());
                dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsLoginKanri).getTableId());
                dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSLOGINKANRI);
                dsHenkouRireki.setHenkoukoumokuid(MT_DsLoginKanri.DSKOKNO);
                dsHenkouRireki.setHenkoukoumokunm(
                    ((AbstractExDBEntity<?,?>)dsLoginKanri).getFieldViewName(MT_DsLoginKanri.DSKOKNO));
                dsHenkouRireki.setNewnaiyou(dsLoginKanri.getDskokno());
                dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(dsHenkouRireki);
            }

            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                MT_BAK_DsLoginKanri bakDsLoginKanri =bakDsKokyakuKanri.getBAKDsLoginKanri();

                MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

                entityFieldsForCompare(
                    dsLoginKanri, bakDsLoginKanri, dsTtdkRireki, SYORIKBN_LOGIN, gyoumuKousinTime);
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_DsMailAddress> dsMailAddressList = dsKokyakuKanri.getDsMailAddresss();

                for (MT_DsMailAddress dsMailAddress : dsMailAddressList) {

                    MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                    renno = renno + 1;

                    dsHenkouRireki.setRenno(renno);
                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsMailAddress).getViewName());
                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsMailAddress).getTableId());
                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                    dsHenkouRireki.setHanbetukoumokunm(
                        HANBETUKOUMOKUNM_DSMAILADDRESS.concat(dsMailAddress.getDsmailaddressrenban().toString()));
                    dsHenkouRireki.setHenkoukoumokuid(MT_DsMailAddress.DSKOKNO);
                    dsHenkouRireki.setHenkoukoumokunm(
                        ((AbstractExDBEntity<?,?>)dsMailAddress).getFieldViewName(MT_DsMailAddress.DSKOKNO));
                    dsHenkouRireki.setNewnaiyou("ＤＳ顧客番号：".concat(dsMailAddress.getDskokno()));
                    dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                    dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                    dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(dsHenkouRireki);
                }
            }
            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_BAK_DsMailAddress> bakDsMailAddressList = bakDsKokyakuKanri.getBAKDsMailAddresss();

                List<MT_DsMailAddress> dsMailAddressList = dsKokyakuKanri.getDsMailAddresss();

                for (MT_BAK_DsMailAddress bakDsMailAddress : bakDsMailAddressList) {

                    for (MT_DsMailAddress dsDsMailAddress : dsMailAddressList) {

                        if (bakDsMailAddress.getDsmailaddressrenban().equals(dsDsMailAddress.getDsmailaddressrenban())) {
                            entityFieldsForCompare(dsDsMailAddress, bakDsMailAddress, dsTtdkRireki
                                , SYORIKBN_MAILADDRESS, gyoumuKousinTime);
                        }
                    }
                }

                for (MT_DsMailAddress dsDsMailAddress : dsMailAddressList) {

                    boolean existFlag = false;

                    for (MT_BAK_DsMailAddress bakDsMailAddress : bakDsMailAddressList) {

                        if (dsDsMailAddress.getDsmailaddressrenban().equals(bakDsMailAddress.getDsmailaddressrenban())) {
                            existFlag = true;
                            break;
                        }
                    }

                    if (!existFlag) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsDsMailAddress).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsDsMailAddress).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSMAILADDRESS.concat(dsDsMailAddress.getDsmailaddressrenban().toString()));
                        dsHenkouRireki.setHenkoukoumokuid(MT_DsMailAddress.DSKOKNO);
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsDsMailAddress).getFieldViewName(MT_DsMailAddress.DSKOKNO));
                        dsHenkouRireki.setNewnaiyou("ＤＳ顧客番号：".concat(dsDsMailAddress.getDskokno()));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {

                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSTORIHIKISERVICEKANRI.concat(dsTorihikiServiceKanri.getSyono()));
                        dsHenkouRireki.setHenkoukoumokuid(MT_DsTorihikiServiceKanri.SYONO);
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getFieldViewName(MT_DsTorihikiServiceKanri.SYONO));
                        dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsTorihikiServiceKanri.getSyono()));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }
            }
            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_BAK_DsTorihikiServiceKanri> bakDsTorihikiServiceKanriList = new ArrayList<>();

                List<MT_BAK_DsKokyakuKeiyaku> bakDsKokyakuKeiyakuList = bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus();

                for (MT_BAK_DsKokyakuKeiyaku bakDsKokyakuKeiyaku : bakDsKokyakuKeiyakuList) {
                    MT_BAK_DsTorihikiServiceKanri bakDsTorihikiServiceKanri = bakDsKokyakuKeiyaku.getBAKDsTorihikiServiceKanri();

                    if (bakDsTorihikiServiceKanri != null) {

                        bakDsTorihikiServiceKanriList.add(bakDsTorihikiServiceKanri);
                    }
                }

                List<MT_DsTorihikiServiceKanri> dsTorihikiServiceKanriList = new ArrayList<>();

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {

                        dsTorihikiServiceKanriList.add(dsTorihikiServiceKanri);
                    }
                }

                for (MT_BAK_DsTorihikiServiceKanri bakDsTorihikiServiceKanri : bakDsTorihikiServiceKanriList) {
                    for (MT_DsTorihikiServiceKanri dsTorihikiServiceKanri : dsTorihikiServiceKanriList) {

                        if (bakDsTorihikiServiceKanri.getSyono().equals(dsTorihikiServiceKanri.getSyono())) {
                            entityFieldsForCompare(dsTorihikiServiceKanri, bakDsTorihikiServiceKanri, dsTtdkRireki,
                                SYORIKBN_TORIHIKISERVICEKANRI, gyoumuKousinTime);
                        }
                    }
                }

                for (MT_DsTorihikiServiceKanri dsTorihikiServiceKanri : dsTorihikiServiceKanriList) {

                    boolean existFlag = false;

                    for (MT_BAK_DsTorihikiServiceKanri bakDsTorihikiServiceKanri : bakDsTorihikiServiceKanriList) {

                        if (dsTorihikiServiceKanri.getSyono().equals(bakDsTorihikiServiceKanri.getSyono())) {
                            existFlag = true;
                            break;
                        }
                    }

                    if (!existFlag) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSTORIHIKISERVICEKANRI.concat(dsTorihikiServiceKanri.getSyono()));
                        dsHenkouRireki.setHenkoukoumokuid(MT_DsTorihikiServiceKanri.SYONO);
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getFieldViewName(MT_DsTorihikiServiceKanri.SYONO));
                        dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsTorihikiServiceKanri.getSyono()));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {
                        List<MT_DsSoukinyouKouza> dsSoukinyouKouzaList = dsTorihikiServiceKanri.getDsSoukinyouKouzas();

                        for (MT_DsSoukinyouKouza dsSoukinyouKouza : dsSoukinyouKouzaList) {

                            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                            renno = renno + 1;

                            dsHenkouRireki.setRenno(renno);
                            dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getViewName());
                            dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getTableId());
                            dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                            dsHenkouRireki.setHanbetukoumokunm(
                                HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_SYONO.concat(dsSoukinyouKouza.getSyono()).concat("　")
                                .concat(HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_KZSYURUIKBN).concat(dsSoukinyouKouza.getKzsyuruikbn().getContent()));
                            dsHenkouRireki.setHenkoukoumokuid(
                                MT_DsSoukinyouKouza.SYONO.concat(", ").concat(MT_DsSoukinyouKouza.KZSYURUIKBN));
                            dsHenkouRireki.setHenkoukoumokunm(
                                ((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getFieldViewName(MT_DsSoukinyouKouza.SYONO)
                                .concat("、")
                                .concat(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getFieldViewName(MT_DsSoukinyouKouza.KZSYURUIKBN)));
                            dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsSoukinyouKouza.getSyono())
                                .concat("　口座種類区分：".concat(dsSoukinyouKouza.getKzsyuruikbn().getContent())));
                            dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                            dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                            dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                            BizPropertyInitializer.initialize(dsHenkouRireki);
                        }
                    }
                }
            }
            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_BAK_DsSoukinyouKouza> bakDsSoukinyouKouzaList = new ArrayList<>();

                List<MT_BAK_DsKokyakuKeiyaku> bakDsKokyakuKeiyakuList = bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus();

                for (MT_BAK_DsKokyakuKeiyaku bakDsKokyakuKeiyaku : bakDsKokyakuKeiyakuList) {
                    MT_BAK_DsTorihikiServiceKanri bakDsTorihikiServiceKanri = bakDsKokyakuKeiyaku.getBAKDsTorihikiServiceKanri();

                    if (bakDsTorihikiServiceKanri != null) {

                        List<MT_BAK_DsSoukinyouKouza> bakDsSoukinyouKouzaLst = bakDsTorihikiServiceKanri.getBAKDsSoukinyouKouzas();

                        if (bakDsSoukinyouKouzaLst.size() > 0) {

                            bakDsSoukinyouKouzaList.addAll(bakDsSoukinyouKouzaLst);
                        }
                    }
                }

                List<MT_DsSoukinyouKouza> dsSoukinyouKouzaList = new ArrayList<>();

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {

                        List<MT_DsSoukinyouKouza> dsSoukinyouKouzaLst = dsTorihikiServiceKanri.getDsSoukinyouKouzas();

                        if (dsSoukinyouKouzaLst.size() > 0) {

                            dsSoukinyouKouzaList.addAll(dsSoukinyouKouzaLst);
                        }
                    }
                }

                for (MT_BAK_DsSoukinyouKouza bakDsSoukinyouKouza : bakDsSoukinyouKouzaList) {
                    for (MT_DsSoukinyouKouza dsSoukinyouKouza : dsSoukinyouKouzaList) {
                        if (bakDsSoukinyouKouza.getSyono().equals(dsSoukinyouKouza.getSyono()) &&
                            bakDsSoukinyouKouza.getKzsyuruikbn().eq(dsSoukinyouKouza.getKzsyuruikbn())) {
                            entityFieldsForCompare(dsSoukinyouKouza, bakDsSoukinyouKouza, dsTtdkRireki
                                , SYORIKBN_SOUKINYOUKOUZA, gyoumuKousinTime);
                        }
                    }
                }

                for (MT_DsSoukinyouKouza dsSoukinyouKouza : dsSoukinyouKouzaList) {

                    boolean existFlag = false;

                    for (MT_BAK_DsSoukinyouKouza bakDsSoukinyouKouza : bakDsSoukinyouKouzaList) {
                        if (dsSoukinyouKouza.getSyono().equals(bakDsSoukinyouKouza.getSyono()) &&
                            dsSoukinyouKouza.getKzsyuruikbn().eq(bakDsSoukinyouKouza.getKzsyuruikbn())) {
                            existFlag = true;
                            break;
                        }
                    }

                    if (!existFlag) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_SYONO.concat(dsSoukinyouKouza.getSyono()).concat("　")
                            .concat(HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_KZSYURUIKBN).concat(dsSoukinyouKouza.getKzsyuruikbn().getContent()));
                        dsHenkouRireki.setHenkoukoumokuid(
                            MT_DsSoukinyouKouza.SYONO.concat(", ").concat(MT_DsSoukinyouKouza.KZSYURUIKBN));
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getFieldViewName(MT_DsSoukinyouKouza.SYONO)
                            .concat("、")
                            .concat(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getFieldViewName(MT_DsSoukinyouKouza.KZSYURUIKBN)));
                        dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsSoukinyouKouza.getSyono())
                            .concat("　口座種類区分：".concat(dsSoukinyouKouza.getKzsyuruikbn().getContent())));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }
            }

            if (null == bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {

                        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();

                        if (dsTorihikiyouAnsyono != null) {

                            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                            renno = renno + 1;

                            dsHenkouRireki.setRenno(renno);
                            dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getViewName());
                            dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getTableId());
                            dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                            dsHenkouRireki.setHanbetukoumokunm(
                                HANBETUKOUMOKUNM_DSTORIHIKIYOUANSYONO.concat(dsTorihikiyouAnsyono.getSyono()));
                            dsHenkouRireki.setHenkoukoumokuid(MT_DsTorihikiyouAnsyono.SYONO);
                            dsHenkouRireki.setHenkoukoumokunm(
                                ((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getFieldViewName(MT_DsTorihikiyouAnsyono.SYONO));
                            dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsTorihikiyouAnsyono.getSyono()));
                            dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                            dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                            dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                            BizPropertyInitializer.initialize(dsHenkouRireki);
                        }
                    }
                }
            }
            else if (null != bakDsKokyakuKanri && null != dsKokyakuKanri) {

                List<MT_BAK_DsTorihikiyouAnsyono> bakDsTorihikiyouAnsyonoList = new ArrayList<>();

                List<MT_BAK_DsKokyakuKeiyaku> bakDsKokyakuKeiyakuList = bakDsKokyakuKanri.getBAKDsKokyakuKeiyakus();

                for (MT_BAK_DsKokyakuKeiyaku bakDsKokyakuKeiyaku : bakDsKokyakuKeiyakuList) {
                    MT_BAK_DsTorihikiServiceKanri bakDsTorihikiServiceKanri = bakDsKokyakuKeiyaku.getBAKDsTorihikiServiceKanri();

                    if (bakDsTorihikiServiceKanri != null) {

                        MT_BAK_DsTorihikiyouAnsyono bakDsTorihikiyouAnsyono = bakDsTorihikiServiceKanri.getBAKDsTorihikiyouAnsyono();

                        if (bakDsTorihikiyouAnsyono != null) {

                            bakDsTorihikiyouAnsyonoList.add(bakDsTorihikiyouAnsyono);
                        }
                    }
                }

                List<MT_DsTorihikiyouAnsyono> dsTorihikiyouAnsyonoList = new ArrayList<>();

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuList) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {

                        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();

                        if (dsTorihikiyouAnsyono != null) {

                            dsTorihikiyouAnsyonoList.add(dsTorihikiyouAnsyono);
                        }
                    }
                }

                for (MT_BAK_DsTorihikiyouAnsyono bakDsTorihikiyouAnsyono : bakDsTorihikiyouAnsyonoList) {
                    for (MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono : dsTorihikiyouAnsyonoList) {

                        if (bakDsTorihikiyouAnsyono.getSyono().equals(dsTorihikiyouAnsyono.getSyono())) {
                            entityFieldsForCompare(dsTorihikiyouAnsyono, bakDsTorihikiyouAnsyono, dsTtdkRireki
                                , SYORIKBN_TORIHIKIYOUANSYONO, gyoumuKousinTime);
                        }
                    }
                }

                for (MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono : dsTorihikiyouAnsyonoList) {

                    boolean existFlag = false;

                    for (MT_BAK_DsTorihikiyouAnsyono bakDsTorihikiyouAnsyono : bakDsTorihikiyouAnsyonoList) {
                        if (dsTorihikiyouAnsyono.getSyono().equals(bakDsTorihikiyouAnsyono.getSyono())) {
                            existFlag = true;
                            break;
                        }
                    }

                    if (!existFlag) {

                        MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();

                        renno = renno + 1;

                        dsHenkouRireki.setRenno(renno);
                        dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getViewName());
                        dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getTableId());
                        dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.TUIKA);
                        dsHenkouRireki.setHanbetukoumokunm(
                            HANBETUKOUMOKUNM_DSTORIHIKIYOUANSYONO.concat(dsTorihikiyouAnsyono.getSyono()));
                        dsHenkouRireki.setHenkoukoumokuid(MT_DsTorihikiyouAnsyono.SYONO);
                        dsHenkouRireki.setHenkoukoumokunm(
                            ((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getFieldViewName(MT_DsSoukinyouKouza.SYONO));
                        dsHenkouRireki.setNewnaiyou("証券番号：".concat(dsTorihikiyouAnsyono.getSyono()));
                        dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                        dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                        dsHenkouRireki.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsHenkouRireki);
                    }
                }
            }
        }

        dsTtdkRireki.setSyoriYmd(pDsTetudukiRirekiTableEditParam.getSyoriYmd());
        dsTtdkRireki.setDssyorikbn(pDsTetudukiRirekiTableEditParam.getDssyorikbn());

        if (0 == renno) {
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.NONE);
        } else {
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);
        }

        dsTtdkRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
        dsTtdkRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
        dsTtdkRireki.setGyoumuKousinTime(gyoumuKousinTime);

        BizPropertyInitializer.initialize(dsTtdkRireki);
    }

    private void entityFieldsForCompare(
        Object pObj, Object pBakObj, MT_DsTtdkRireki pDsTtdkRireki, String pSyoriKbn, String pGyoumuKousinTime) {

        String gyoumuKousinKinou = kinou.getKinouId();
        String gyoumuKousinsyaId = baseUserInfo.getUserId();

        Field[] superFieldList = pObj.getClass().getSuperclass().getDeclaredFields();
        for (Field field : superFieldList) {
            if (null != field.getName() && field.getName().length() > 0) {

                if ("gyoumuKousinKinou".equals(field.getName())
                    || "gyoumuKousinsyaId".equals(field.getName())
                    || "gyoumuKousinTime".equals(field.getName())
                    || "kousinKinou".equals(field.getName())
                    || "kousinsyaId".equals(field.getName())
                    || "kousinTime".equals(field.getName())
                    || "version".equals(field.getName())
                    || "dskokno".equals(field.getName())
                    || "syono".equals(field.getName())
                    || "dsmailaddressrenban".equals(field.getName())) {
                    continue;
                }

                String setMethodName =
                    "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                String getMethodName =
                    "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Class<?> c = field.getType();
                Method getM = null;
                Method getM1 = null;
                try {
                    if (isMethodExist(pObj, setMethodName, c, "set")
                        && isMethodExist(pObj, getMethodName, c, "get")) {
                        getM = pObj.getClass().getMethod(getMethodName);
                        getM1 = pBakObj.getClass().getMethod(getMethodName);
                        try {
                            Object obj = getM.invoke(pObj);
                            Object objBak = getM1.invoke(pBakObj);

                            if ((null != objBak && !objBak.equals(obj)) || (obj != null && !obj.equals(objBak))) {

                                MT_DsHenkouRireki dsHenkouRireki = pDsTtdkRireki.createDsHenkouRireki();

                                String newValue = null;
                                if (null != obj) {
                                    newValue = obj.toString();
                                }

                                String bakValue = null;
                                if (null != objBak) {
                                    bakValue = objBak.toString();
                                }

                                renno = renno + 1;

                                if (SYORIKBN_KOKYAKUJYOUHOU.equals(pSyoriKbn)) {

                                    MT_DsKokyakuKanri dsKokyakuKanri = (MT_DsKokyakuKanri)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsKokyakuKanri).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsKokyakuKanri).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSKOKYAKUKANRI);
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsKokyakuKanri).getFieldViewName(field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    if (MT_DsKokyakuKanri.DSKOKYAKUJTKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsKokyakuJtKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsKokyakuKanri.DSTEISIRIYUUKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsTeisiRiyuuKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsKokyakuKanri.SEISAHUYOUHYJ.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_SeisaHuyouHyj.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsKokyakuKanri.DSKANYUUKEIROKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsKanyuuKeiroKbn.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    if (MT_DsKokyakuKanri.DSKOKYAKUJTKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsKokyakuJtKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsKokyakuKanri.DSTEISIRIYUUKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsTeisiRiyuuKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsKokyakuKanri.SEISAHUYOUHYJ.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_SeisaHuyouHyj.getContentByValue(newValue));
                                    }
                                    else if (MT_DsKokyakuKanri.DSKANYUUKEIROKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsKanyuuKeiroKbn.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }
                                }
                                else if (SYORIKBN_KEIYAKUJYOUHOU.equals(pSyoriKbn)) {

                                    MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = (MT_DsKokyakuKeiyaku)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSKOKYAKUKEIYAKU
                                        + dsKokyakuKeiyaku.getSyono());
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsKokyakuKeiyaku).getFieldViewName(
                                            field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    if (MT_DsKokyakuKeiyaku.DSKYKMUKOUHYJ.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_MukouHyj.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsKokyakuKeiyaku.PPLESSRENJIDSSYMENTTDKHYJ.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsSyomenTtdkHyouji.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    if (MT_DsKokyakuKeiyaku.DSKYKMUKOUHYJ.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_MukouHyj.getContentByValue(newValue));
                                    }
                                    else if (MT_DsKokyakuKeiyaku.PPLESSRENJIDSSYMENTTDKHYJ.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsSyomenTtdkHyouji.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }

                                }
                                else if (SYORIKBN_HONNINKAKUNINCD.equals(pSyoriKbn)) {

                                    MT_DsHonninKakuninCd dsHonninKakuninCd = (MT_DsHonninKakuninCd)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsHonninKakuninCd).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsHonninKakuninCd).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSHONNINKAKUNINCD);
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsHonninKakuninCd).getFieldViewName(
                                            field.getName()));
                                    if (MT_DsHonninKakuninCd.DSKRHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.DSHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.ZENKAIDSKRHNNKAKCD.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyouoriginal(HITOKU);
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    }
                                    if (MT_DsHonninKakuninCd.DSKRHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.DSHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.ZENKAIDSKRHNNKAKCD.equals(field.getName())) {

                                        dsHenkouRireki.setBfrnaiyou(HITOKU);
                                    }
                                    else if (MT_DsHonninKakuninCd.DSKRHNNKAKCDSETKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsKrHnnKakCdSetKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsHonninKakuninCd.DSKRHNNKAKCDTTYHKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsKrHnnKakCdTtYhKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsHonninKakuninCd.DSKRHNNKAKCDTTTYDNJYKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsKrHnnKakCdTtTydnJyKbn.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    if (MT_DsHonninKakuninCd.DSKRHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.DSHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.ZENKAIDSKRHNNKAKCD.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyouoriginal(HITOKU);
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    }
                                    if (MT_DsHonninKakuninCd.DSKRHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.DSHNNKAKCD.equals(field.getName())
                                        || MT_DsHonninKakuninCd.ZENKAIDSKRHNNKAKCD.equals(field.getName())) {

                                        dsHenkouRireki.setNewnaiyou(HITOKU);
                                    }
                                    else if (MT_DsHonninKakuninCd.DSKRHNNKAKCDSETKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsKrHnnKakCdSetKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsHonninKakuninCd.DSKRHNNKAKCDTTYHKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsKrHnnKakCdTtYhKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsHonninKakuninCd.DSKRHNNKAKCDTTTYDNJYKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsKrHnnKakCdTtTydnJyKbn.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }
                                }
                                else if (SYORIKBN_LOGIN.equals(pSyoriKbn)) {

                                    MT_DsLoginKanri dsLoginKanri = (MT_DsLoginKanri)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsLoginKanri).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsLoginKanri).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSLOGINKANRI);
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsLoginKanri).getFieldViewName(field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    if (MT_DsLoginKanri.SYOKAILOGINBAITAIKBN.equals(field.getName())
                                        || MT_DsLoginKanri.SAISINLOGINBAITAIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_BaitaiKbn.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    if (MT_DsLoginKanri.SYOKAILOGINBAITAIKBN.equals(field.getName())
                                        || MT_DsLoginKanri.SAISINLOGINBAITAIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_BaitaiKbn.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }
                                }
                                else if (SYORIKBN_MAILADDRESS.equals(pSyoriKbn)) {

                                    MT_DsMailAddress dsMailAddress = (MT_DsMailAddress)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsMailAddress).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsMailAddress).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSMAILADDRESS
                                        + dsMailAddress.getDsmailaddressrenban().toString());
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsMailAddress).getFieldViewName(
                                            field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    if (MT_DsMailAddress.DSMAILTOUROKUJYOUTAIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsMailTourokuJyoutaiKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsMailAddress.DSMAILSOUSINJYOUTAIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsMailSousinJyoutaiKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsMailAddress.DSMAILSOUSINTISRYKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsMailSousinTeisiRiyuuKbn.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    if (MT_DsMailAddress.DSMAILTOUROKUJYOUTAIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsMailTourokuJyoutaiKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsMailAddress.DSMAILSOUSINJYOUTAIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsMailSousinJyoutaiKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsMailAddress.DSMAILSOUSINTISRYKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsMailSousinTeisiRiyuuKbn.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }
                                }
                                else if (SYORIKBN_TORIHIKISERVICEKANRI.equals(pSyoriKbn)) {

                                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = (MT_DsTorihikiServiceKanri)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSTORIHIKISERVICEKANRI
                                        + dsTorihikiServiceKanri.getSyono());
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsTorihikiServiceKanri).getFieldViewName(
                                            field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    if (MT_DsTorihikiServiceKanri.DSTRHKSERVICERIYOUJKKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsTrhkserviceRiyoujkKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsTorihikiServiceKanri.DSTRHKSERVICETEISIRIYUUKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsTrhkserviceTeisiRiyuuKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsTorihikiServiceKanri.DSTRHKSERVICEKANYUKEIROKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(
                                            C_DsTrhkserviceKanyukeiroKbn.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    if (MT_DsTorihikiServiceKanri.DSTRHKSERVICERIYOUJKKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsTrhkserviceRiyoujkKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsTorihikiServiceKanri.DSTRHKSERVICETEISIRIYUUKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsTrhkserviceTeisiRiyuuKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsTorihikiServiceKanri.DSTRHKSERVICEKANYUKEIROKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(
                                            C_DsTrhkserviceKanyukeiroKbn.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }
                                }
                                else if (SYORIKBN_SOUKINYOUKOUZA.equals(pSyoriKbn)) {

                                    MT_DsSoukinyouKouza dsSoukinyouKouza = (MT_DsSoukinyouKouza)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_SYONO
                                        + dsSoukinyouKouza.getSyono() +"　"+ HANBETUKOUMOKUNM_DSSOUKINYOUKOUZA_KZSYURUIKBN
                                        + dsSoukinyouKouza.getKzsyuruikbn().getContent());
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsSoukinyouKouza).getFieldViewName(
                                            field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    if (MT_DsSoukinyouKouza.KZSYURUIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(C_KouzasyuruiKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsSoukinyouKouza.YOKINKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(C_YokinKbn.getContentByValue(bakValue));
                                    }
                                    else if (MT_DsSoukinyouKouza.KZDOUKBN.equals(field.getName())) {
                                        dsHenkouRireki.setBfrnaiyou(C_Kzdou.getContentByValue(bakValue));
                                    }
                                    else {
                                        dsHenkouRireki.setBfrnaiyou(bakValue);
                                    }
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    if (MT_DsSoukinyouKouza.KZSYURUIKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(C_KouzasyuruiKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsSoukinyouKouza.YOKINKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(C_YokinKbn.getContentByValue(newValue));
                                    }
                                    else if (MT_DsSoukinyouKouza.KZDOUKBN.equals(field.getName())) {
                                        dsHenkouRireki.setNewnaiyou(C_Kzdou.getContentByValue(newValue));
                                    }
                                    else {
                                        dsHenkouRireki.setNewnaiyou(newValue);
                                    }
                                }
                                else if (SYORIKBN_TORIHIKIYOUANSYONO.equals(pSyoriKbn)) {

                                    MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = (MT_DsTorihikiyouAnsyono)pObj;

                                    dsHenkouRireki.setRenno(renno);
                                    dsHenkouRireki.setTablenm(((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getViewName());
                                    dsHenkouRireki.setTableid(((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getTableId());
                                    dsHenkouRireki.setHnksyuruikbn(C_HnkSyuruiKbn.HENKOU);
                                    dsHenkouRireki.setHanbetukoumokunm(HANBETUKOUMOKUNM_DSTORIHIKIYOUANSYONO
                                        + dsTorihikiyouAnsyono.getSyono());
                                    dsHenkouRireki.setHenkoukoumokuid(field.getName());
                                    dsHenkouRireki.setHenkoukoumokunm(
                                        ((AbstractExDBEntity<?,?>)dsTorihikiyouAnsyono).getFieldViewName(
                                            field.getName()));
                                    dsHenkouRireki.setBfrnaiyouoriginal(bakValue);
                                    dsHenkouRireki.setBfrnaiyou(bakValue);
                                    dsHenkouRireki.setNewnaiyouoriginal(newValue);
                                    dsHenkouRireki.setNewnaiyou(newValue);
                                }

                                dsHenkouRireki.setGyoumuKousinKinou(gyoumuKousinKinou);
                                dsHenkouRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                                dsHenkouRireki.setGyoumuKousinTime(pGyoumuKousinTime);

                                BizPropertyInitializer.initialize(dsHenkouRireki);
                            }
                        } catch (SecurityException | IllegalAccessException
                            | IllegalArgumentException
                            | InvocationTargetException e) {
                            throw new BizAppException(e, MessageId.EBC0001,
                                "ＤＳ手続履歴テーブル編集の時、想定外の異常が発生しました。");
                        }
                    }
                } catch (NoSuchMethodException | SecurityException e) {
                    throw new BizAppException(e, MessageId.EBC0001,
                        "ＤＳ手続履歴テーブル編集の時、想定外の異常が発生しました。");
                }
            }
        }
    }

    private boolean isMethodExist(Object obj, String mName, Class<?> c, String type) {
        Method[] methodList = obj.getClass().getMethods();
        for (Method m : methodList) {
            if (m.getName().equals(mName)) {
                Class<?>[] cList = m.getParameterTypes();
                if (type.equals("get") && cList.length == 0) {
                    return true;
                }
                if (type.equals("set") && cList.length == 1 && cList[0].equals(c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
