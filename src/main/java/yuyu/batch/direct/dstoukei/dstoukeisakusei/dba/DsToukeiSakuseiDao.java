package yuyu.batch.direct.dstoukei.dstoukeisakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QMT_DsHenkouRireki;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsLoginKanri;
import yuyu.def.db.meta.QMT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsTorihikiServiceKanri;
import yuyu.def.db.meta.QMT_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.QMT_DsTtdkRireki;
import yuyu.def.db.meta.QMV_MailAddressRenbanSaisin;

/**
 * ダイレクトサービス ＤＳ統計 ＤＳ統計Ｆ作成機能DAOクラス
 */
public class DsToukeiSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getDsKokyakuKeiyakuKensuu() {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qMT_DsKokyakuKeiyaku);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKeiyaku).getSingleResult();
    }

    public ExDBResults<DsToukeiInfosBean> getDsToukeiInfosOrderByKoknoSyono() {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd("qMT_DsHonninKakuninCd");
        QMT_DsLoginKanri qMT_DsLoginKanri = new QMT_DsLoginKanri("qMT_DsLoginKanri");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsMailAddress qMT_DsMailAddress = new QMT_DsMailAddress("qMT_DsMailAddress");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");
        QMT_DsTtdkRireki qMT_DsTtdkRireki = new QMT_DsTtdkRireki("qMT_DsTtdkRireki");
        QMT_DsHenkouRireki qMT_DsHenkouRireki = new QMT_DsHenkouRireki("qMT_DsHenkouRireki");
        QMT_DsTorihikiServiceKanri qMT_DsTorihikiServiceKanri = new QMT_DsTorihikiServiceKanri("qMT_DsTorihikiServiceKanri");
        QMT_DsSoukinyouKouza qMT_DsSoukinyouKouza = new QMT_DsSoukinyouKouza("qMT_DsSoukinyouKouza");
        QMT_DsTorihikiyouAnsyono qMT_DsTorihikiyouAnsyono = new QMT_DsTorihikiyouAnsyono("qMT_DsTorihikiyouAnsyono");
        QMV_MailAddressRenbanSaisin qMV_MailAddressRenbanSaisin = new QMV_MailAddressRenbanSaisin(
            "qMV_MailAddressRenbanSaisin");


        String subQuery = $SELECT + $MAX(qMT_DsHenkouRireki.gyoumuKousinTime) +
            $FROM (qMT_DsTtdkRireki,
                qMT_DsHenkouRireki) +
                $WHERE  + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsTtdkRireki.dskokno) +
                $AND + qMT_DsTtdkRireki.dskokno.eq(qMT_DsHenkouRireki.dskokno) +
                $AND + qMT_DsTtdkRireki.henkousikibetukey.eq(qMT_DsHenkouRireki.henkousikibetukey) +
                $AND + $(qMT_DsHenkouRireki.gyoumuKousinKinou.eq("dsKokyakuTouroku") +
                    $OR + qMT_DsHenkouRireki.gyoumuKousinKinou.eq("dsSeirituKokyakuSakusei")) +
                    $AND + qMT_DsHenkouRireki.tableid.eq("MT_DsMailAddress") +
                    $AND + qMT_DsHenkouRireki.henkoukoumokuid.eq("dsmailaddress") +
                    $GROUP_BY + qMT_DsHenkouRireki.dskokno + "," +
                    qMT_DsHenkouRireki.henkousikibetukey;

        String subQuery2 = $SELECT + qMT_DsSoukinyouKouza.kzsyuruikbn +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE  + qMT_DsKokyakuKeiyaku.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(C_KouzasyuruiKbn.YENKOUZA);


        String subQuery3 = $SELECT + qMT_DsSoukinyouKouza.bankcd +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE  + qMT_DsKokyakuKeiyaku.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(C_KouzasyuruiKbn.YENKOUZA);

        String subQuery4 = $SELECT + qMT_DsSoukinyouKouza.sitencd +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE  + qMT_DsKokyakuKeiyaku.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(C_KouzasyuruiKbn.YENKOUZA);

        String subQuery5 = $SELECT + qMT_DsSoukinyouKouza.yokinkbn +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE  + qMT_DsKokyakuKeiyaku.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(C_KouzasyuruiKbn.YENKOUZA);

        String subQuery6 = $SELECT + qMT_DsSoukinyouKouza.kouzano +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE  + qMT_DsKokyakuKeiyaku.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(C_KouzasyuruiKbn.YENKOUZA);

        String subQuery7 = $SELECT + qMT_DsSoukinyouKouza.kzdoukbn +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE  + qMT_DsKokyakuKeiyaku.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(C_KouzasyuruiKbn.YENKOUZA);

        String strSql = $SELECT + $NEW(DsToukeiInfosBean.class
            ,qMT_DsKokyakuKanri.dskokno
            ,qMT_DsKokyakuKanri.dskokyakujtkbn
            ,qMT_DsKokyakuKanri.dskokyakusakuseiymd
            ,qMT_DsKokyakuKanri.dsteisiriyuukbn
            ,qMT_DsKokyakuKanri.dskokyakumukouymd
            ,qMT_DsKokyakuKanri.seisahuyouhyj
            ,qMT_DsKokyakuKanri.dskokyakuseiymd
            ,qMT_DsKokyakuKanri.dskokyakuyno
            ,qMT_DsKokyakuKanri.dskanyuukeirokbn
            ,qMT_DsHonninKakuninCd.dskrhnnkakcdsetkbn
            ,qMT_DsHonninKakuninCd.dskrhnnkakcdsetymd
            ,qMT_DsHonninKakuninCd.dskrhnnkakcdyuukouymd
            ,qMT_DsHonninKakuninCd.dshnnkakcdsetymd
            ,qMT_DsHonninKakuninCd.dskrhnnkakcdttshjyhsymd
            ,qMT_DsHonninKakuninCd.dskrhnnkakcdttyhkbn
            ,qMT_DsHonninKakuninCd.dskrhnnkakcdtttydnjykbn
            ,qMT_DsLoginKanri.syokailoginymd
            ,qMT_DsLoginKanri.syokailogintime
            ,qMT_DsLoginKanri.syokailoginbaitaikbn
            ,qMT_DsLoginKanri.saisinloginymd
            ,qMT_DsLoginKanri.saisinlogintime
            ,qMT_DsLoginKanri.saisinloginbaitaikbn
            ,qMT_DsLoginKanri.dshnnkakcderrorkaisuu
            ,qMT_DsLoginKanri.dskokyakunmerrorkaisuu
            ,qMT_DsLoginKanri.dskokyakuseiymderrorkaisuu
            ,qMT_DsLoginKanri.dskokyakutelnoerrorkaisuu
            ,qMT_DsKokyakuKeiyaku.syono
            ,qMT_DsKokyakuKeiyaku.dskykkanyuuymd
            ,qMT_DsKokyakuKeiyaku.dskykhenkouymd
            ,qMT_DsKokyakuKeiyaku.dskykmukouhyj
            ,qMT_DsKokyakuKeiyaku.dskykmukouymd
            ,qMT_DsKokyakuKeiyaku.pplessrenjidssymenttdkhyj
            ,qMT_DsMailAddress.dsmailtourokujyoutaikbn
            ,qMT_DsMailAddress.dsmailaddress
            ,qMT_DsMailAddress.dsmailsousinjyoutaikbn
            ,qMT_DsMailAddress.dsmailsousintisrykbn
            ,qMT_DsMailAddress.dstourokuymdtime
            ,qMT_DsMailAddress.dskousinymdtime
            ,qIT_KykKihon.skjmosno
            ,qIT_KykKihon.mosuketukekbn
            ,qIT_KykSya.kyksei
            ,qIT_KykDairiten.bsyujoyadrtencd
            ,qIT_KykDairiten.bsyujdrtencd
            ,$(subQuery)
            ,qMT_DsTorihikiServiceKanri.dstrhkserviceriyoujkkbn
            ,qMT_DsTorihikiServiceKanri.dstrhkserviceteisiriyuukbn
            ,qMT_DsTorihikiServiceKanri.dstrhkservicetourokuymd
            ,qMT_DsTorihikiServiceKanri.dstrhkservicemukouymd
            ,qMT_DsTorihikiServiceKanri.dstrhkservicekanyukeirokbn
            ,$(subQuery2)
            ,$(subQuery3)
            ,$(subQuery4)
            ,$(subQuery5)
            ,$(subQuery6)
            ,$(subQuery7)
            ,qMT_DsTorihikiyouAnsyono.tokuteitrhkansyono
            ,qMT_DsTorihikiyouAnsyono.tktrhkansyonoerrorkaisuu
            ,qMT_DsTorihikiyouAnsyono.setymd) +
            $FROM(qMT_DsKokyakuKanri
                ,qMT_DsHonninKakuninCd
                ,qMT_DsLoginKanri
                ,qMT_DsKokyakuKeiyaku
                ,qMT_DsMailAddress
                ,qIT_KykKihon
                ,qIT_KykSya
                ,qIT_KykDairiten
                ,qMV_MailAddressRenbanSaisin) +
                $LEFT_OUTER_JOIN + qMT_DsKokyakuKeiyaku.MT_DsTorihikiServiceKanri() +
                $AS + qMT_DsTorihikiServiceKanri +
                $LEFT_OUTER_JOIN + qMT_DsTorihikiServiceKanri.MT_DsTorihikiyouAnsyono() +
                $AS + qMT_DsTorihikiyouAnsyono +
                $WHERE + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsLoginKanri.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.syono.eq(qIT_KykKihon.syono) +
                $AND + qMT_DsKokyakuKeiyaku.syono.eq(qIT_KykSya.syono) +
                $AND + qMT_DsKokyakuKeiyaku.syono.eq(qIT_KykDairiten.syono) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsMailAddress.dskokno) +
                $AND + qMV_MailAddressRenbanSaisin.dskokno.eq(qMT_DsMailAddress.dskokno) +
                $AND + qMV_MailAddressRenbanSaisin.dsmailaddressrenban.eq(qMT_DsMailAddress.dsmailaddressrenban) +
                $AND + qIT_KykDairiten.drtenrenno.eq(1) +
                $ORDER_BY(qMT_DsKokyakuKanri.dskokno.asc(),
                    qMT_DsKokyakuKeiyaku.syono.asc());

        return exDBEntityManager
            .createJPQL(strSql, DsToukeiInfosBean.class)
            .bind(qMT_DsKokyakuKanri, qMT_DsHonninKakuninCd, qMT_DsLoginKanri, qMT_DsKokyakuKeiyaku, qMT_DsMailAddress,
                qIT_KykKihon, qIT_KykSya, qIT_KykDairiten, qMV_MailAddressRenbanSaisin, qMT_DsTtdkRireki,
                qMT_DsHenkouRireki, qMT_DsTorihikiServiceKanri, qMT_DsSoukinyouKouza, qMT_DsTorihikiyouAnsyono)
                .getResults();
    }
}
