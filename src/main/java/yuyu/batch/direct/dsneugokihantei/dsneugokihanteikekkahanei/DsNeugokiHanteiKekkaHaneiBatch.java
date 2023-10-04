package yuyu.batch.direct.dsneugokihantei.dsneugokihanteikekkahanei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dsneugokihantei.dsneugokihanteikekkahanei.dba.DsNeugokiHanteiKekkaHaneiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 値動き判定 値動き判定結果反映
 */
public class DsNeugokiHanteiKekkaHaneiBatch implements Batch {

    private static final String DS_NEUGOKI_HANTEI_KEKKA_NM = "ＤＳ値動き判定結果テーブル";

    private static final String DS_MAIL_HAISIN_RIREKI_NM = "ＤＳメール配信履歴テーブル";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DsNeugokiHanteiKekkaHaneiDao dsNeugokiHanteiKekkaHaneiDao;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long dsNeugokiHanteiKekkaKns = 0;
        long dsMailHaisinRirekiKns = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        try (ExDBResults<MW_DsNeugokiHanteiKekkaWk> dsNeugokiHanteiKekkaWkLst = dsNeugokiHanteiKekkaHaneiDao
            .getDsNeugokiHanteiKekkaWk();

            ExDBResults<MW_DsMailHaisinRirekiWk> dsMailHaisinRirekiWkLst = dsNeugokiHanteiKekkaHaneiDao
                .getDsMailHaisinRirekiWk();

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (MW_DsNeugokiHanteiKekkaWk dsNeugokiHanteiKekkaWk : dsNeugokiHanteiKekkaWkLst) {

                dsNeugokiHanteiKekkaKns = dsNeugokiHanteiKekkaKns + 1;

                MT_DsNeugokiHanteiKekka dsNeugokiHanteiKekka = new MT_DsNeugokiHanteiKekka();

                dsNeugokiHanteiKekka.setDsdatasakuseiymd(dsNeugokiHanteiKekkaWk.getDsdatasakuseiymd());
                dsNeugokiHanteiKekka.setSyono(dsNeugokiHanteiKekkaWk.getSyono());
                dsNeugokiHanteiKekka.setDskokno(dsNeugokiHanteiKekkaWk.getDskokno());
                dsNeugokiHanteiKekka.setDsmailaddressrenban(dsNeugokiHanteiKekkaWk.getDsmailaddressrenban());
                dsNeugokiHanteiKekka.setKyknmkn(dsNeugokiHanteiKekkaWk.getKyknmkn());
                dsNeugokiHanteiKekka.setKykymd(dsNeugokiHanteiKekkaWk.getKykymd());
                dsNeugokiHanteiKekka.setBosyuujiaatukaidrtencd(dsNeugokiHanteiKekkaWk.getBosyuujiaatukaidrtencd());
                dsNeugokiHanteiKekka.setBosyuujibatukaidrtencd(dsNeugokiHanteiKekkaWk.getBosyuujibatukaidrtencd());
                dsNeugokiHanteiKekka.setAisyoumeikbn(dsNeugokiHanteiKekkaWk.getAisyoumeikbn());
                dsNeugokiHanteiKekka.setKyktuukasyu(dsNeugokiHanteiKekkaWk.getKyktuukasyu());
                dsNeugokiHanteiKekka.setKaiyakuhryen(dsNeugokiHanteiKekkaWk.getKaiyakuhryen());
                dsNeugokiHanteiKekka.setItijibrp(dsNeugokiHanteiKekkaWk.getItijibrp());
                dsNeugokiHanteiKekka.setNeugokihanteikjnkngk(dsNeugokiHanteiKekkaWk.getNeugokihanteikjnkngk());
                dsNeugokiHanteiKekka.setNeugokiwari(dsNeugokiHanteiKekkaWk.getNeugokiwari());
                dsNeugokiHanteiKekka.setNeugokitoutatulinefile(dsNeugokiHanteiKekkaWk.getNeugokitoutatulinefile());
                dsNeugokiHanteiKekka.setNeugokitoutatulinemail(dsNeugokiHanteiKekkaWk.getNeugokitoutatulinemail());
                dsNeugokiHanteiKekka.setNeugokihanteiumukbn(dsNeugokiHanteiKekkaWk.getNeugokihanteiumukbn());
                dsNeugokiHanteiKekka.setMailsousinyhkbn(dsNeugokiHanteiKekkaWk.getMailsousinyhkbn());
                dsNeugokiHanteiKekka.setMailaddresstourokuumukbn(dsNeugokiHanteiKekkaWk.getMailaddresstourokuumukbn());
                dsNeugokiHanteiKekka.setDssousinno(dsNeugokiHanteiKekkaWk.getDssousinno());
                dsNeugokiHanteiKekka.setGyoumuKousinKinou(dsNeugokiHanteiKekkaWk.getGyoumuKousinKinou());
                dsNeugokiHanteiKekka.setGyoumuKousinsyaId(dsNeugokiHanteiKekkaWk.getGyoumuKousinsyaId());
                dsNeugokiHanteiKekka.setGyoumuKousinTime(dsNeugokiHanteiKekkaWk.getGyoumuKousinTime());

                BizPropertyInitializer.initialize(dsNeugokiHanteiKekka);

                dsNeugokiHanteiKekkaHaneiDao.addMultipleInsertEntity(multipleEntityInserter, dsNeugokiHanteiKekka);
            }

            for (MW_DsMailHaisinRirekiWk dsMailHaisinRirekiWk : dsMailHaisinRirekiWkLst) {

                dsMailHaisinRirekiKns = dsMailHaisinRirekiKns + 1;

                MT_DsMailHaisinRireki dsMailHaisinRireki = new MT_DsMailHaisinRireki();

                dsMailHaisinRireki.setDsdatasakuseiymd(dsMailHaisinRirekiWk.getDsdatasakuseiymd());
                dsMailHaisinRireki.setDskokno(dsMailHaisinRirekiWk.getDskokno());
                dsMailHaisinRireki.setDsmailhaisinrenban(dsMailHaisinRirekiWk.getDsmailhaisinrenban());
                dsMailHaisinRireki.setHaisinjidsmailaddress(dsMailHaisinRirekiWk.getHaisinjidsmailaddress());
                dsMailHaisinRireki.setDssousinno(dsMailHaisinRirekiWk.getDssousinno());
                dsMailHaisinRireki.setGyoumuKousinKinou(dsMailHaisinRirekiWk.getGyoumuKousinKinou());
                dsMailHaisinRireki.setGyoumuKousinsyaId(dsMailHaisinRirekiWk.getGyoumuKousinsyaId());
                dsMailHaisinRireki.setGyoumuKousinTime(dsMailHaisinRirekiWk.getGyoumuKousinTime());
                dsMailHaisinRireki.setDssousinmailsyubetukbn(dsMailHaisinRirekiWk.getDssousinmailsyubetukbn());
                dsMailHaisinRireki.setSyono(dsMailHaisinRirekiWk.getSyono());

                BizPropertyInitializer.initialize(dsMailHaisinRireki);

                dsNeugokiHanteiKekkaHaneiDao.addMultipleInsertEntity(multipleEntityInserter, dsMailHaisinRireki);
            }

            dsNeugokiHanteiKekkaHaneiDao.deleteDsNeugokiHanteiKekkaWk();

            dsNeugokiHanteiKekkaHaneiDao.deleteDsMailHaisinRirekiWk();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dsNeugokiHanteiKekkaKns),
            DS_NEUGOKI_HANTEI_KEKKA_NM));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dsMailHaisinRirekiKns),
            DS_MAIL_HAISIN_RIREKI_NM));
    }
}