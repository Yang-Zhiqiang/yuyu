package yuyu.batch.biz.bzmaster.bzsosikitorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SosikiNmKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（普保用組織ＰＲＴ用連動Ｆテーブル（連））を読み込み、組織マスタに反映するクラス
 */
public class BzSosikiTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BzSosikiTorikomiDao bzSosikiTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long sosikiRnCount = zdbDomManager.getSosikiRnCount();

        if (sosikiRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "普保用組織ＰＲＴ用連動Ｆテーブル（連）");

        }

        deleteSosikiData();

        BzRenkeiHenkanUtil<AM_Sosiki, AM_Sosiki> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(AM_Sosiki.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        sosikiRnCount = registSosikiData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(sosikiRnCount)));
    }

    private void deleteSosikiData() {

        bzSosikiTorikomiDao.deleteSosiki();
    }

    @Transactional
    Long registSosikiData(BzRenkeiHenkanUtil<AM_Sosiki, AM_Sosiki> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (EntityInserter<AM_Sosiki> entityInserter = new EntityInserter<>();
            ExDBResults<ZT_SosikiRn> exDBResults = zdbDomManager.getAllSosikiRn()) {

            AM_Sosiki amSosiki = null;
            for (ZT_SosikiRn ztSosikiRn : exDBResults) {

                amSosiki = createSosikiData(ztSosikiRn);

                amSosiki = pBzRenkeiHenkanUtil.convDouituBean(amSosiki);

                BizPropertyInitializer.initialize(amSosiki);

                entityInserter.add(amSosiki);

                syoriCount++;
            }
        }

        return syoriCount;
    }

    private AM_Sosiki createSosikiData(ZT_SosikiRn pZtSosikiRn) {

        AM_Sosiki amSosiki = new AM_Sosiki();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        String kanjiSosikiNm20 = pZtSosikiRn.getZrnkanjisosikinm20();
        AM_HonyakutsgSosikiCd honyakutsgSosikiCd = baseDomManager.getHonyakutsgSosikiCd(pZtSosikiRn.getZrnsosikicd());
        if ("01".equals(pZtSosikiRn.getZrnsosikinmkbn())) {
            if (20 > StringUtil.rTrim(kanjiSosikiNm20).length()) {
                if (null == honyakutsgSosikiCd) {
                    kanjiSosikiNm20 = StringUtil.rTrim(kanjiSosikiNm20) + "部";
                }
            }
        }
        else if ("02".equals(pZtSosikiRn.getZrnsosikinmkbn())) {
            if (20 > StringUtil.rTrim(kanjiSosikiNm20).length()) {
                if (null == honyakutsgSosikiCd) {
                    kanjiSosikiNm20 = StringUtil.rTrim(kanjiSosikiNm20) + "室";
                }
            }
        }

        amSosiki.setSosikicd(pZtSosikiRn.getZrnsosikicd());
        amSosiki.setSosikinmkbn(C_SosikiNmKbn.valueOf(pZtSosikiRn.getZrnsosikinmkbn()));
        amSosiki.setSosikinm20(pZtSosikiRn.getZrnsosikinm20());
        amSosiki.setKanjisosikinm20(kanjiSosikiNm20);
        bzRenkeiHenkanUtil.convYmZeroToNull(pZtSosikiRn.getZrnsosikihaisiy().concat(pZtSosikiRn.getZrnsosikihaisim()));
        amSosiki.setSosikihaisiym(bzRenkeiHenkanUtil.getConvYmBizDate());
        bzRenkeiHenkanUtil.convYmZeroToNull(pZtSosikiRn.getZrnsosikisinsetuy().concat(
            pZtSosikiRn.getZrnsosikisinsetum()));
        amSosiki.setSosikisinsetuym(bzRenkeiHenkanUtil.getConvYmBizDate());
        amSosiki.setTougetukeisyouusosikicd(pZtSosikiRn.getZrntougetukeisyousosikicd());
        amSosiki.setTougetukeisyoueigyoubucd(BizUtil.zero2blank(pZtSosikiRn.getZrntougetukeisyoueigyoubucd()));
        amSosiki.setZengetukeisyousosikicd(pZtSosikiRn.getZrnzengetukeisyousosikicd());
        amSosiki.setZengetukeisyoueigyoubucd(BizUtil.zero2blank(pZtSosikiRn.getZrnzengetukeisyoueigyoubucd()));
        amSosiki.setSosikikihontikucd(pZtSosikiRn.getZrnsosikikihontikucd());
        amSosiki.setSosikikanjikaijyuusyo30(pZtSosikiRn.getZrnsosikikanjikaiadr30());
        amSosiki.setKanjibirunm15(pZtSosikiRn.getZrnkanjibilunm15());
        amSosiki.setSosikinyuukyokaisuu(pZtSosikiRn.getZrnsosikinyuukyokaisuu());
        amSosiki.setSosikitelno(editTellNo(pZtSosikiRn.getZrnsosikidenwabangousigai(),
            pZtSosikiRn.getZrnsosikitdenwabangousinai(),pZtSosikiRn.getZrnsosikidenwabangoubangou()));
        amSosiki.setSosikifaxno(editTellNo(pZtSosikiRn.getZrnsosikifaxbangousigai(),
            pZtSosikiRn.getZrnsosikifaxbangousinai(),pZtSosikiRn.getZrnsosikifaxbangoubangou()));
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtSosikiRn.getZrnkouryokukaisiy().concat(
            pZtSosikiRn.getZrnkouryokukaisim()).concat(pZtSosikiRn.getZrnkouryokukaisid()));
        amSosiki.setKouryokukaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        amSosiki.setHensosikikihontikucd(pZtSosikiRn.getZrnnewsosikikihontikucd());
        amSosiki.setHenkanjisosikikaijyuusyo30(pZtSosikiRn.getZrnnewkanjisosikikaiadr30());
        amSosiki.setHenkanjibirunm15(pZtSosikiRn.getZrnnewkanjibilunm15());
        amSosiki.setHensosikinyuukyokaisuu(pZtSosikiRn.getZrnnewsosikinyuukyokaisuu());
        amSosiki.setHensosikitelno(editTellNo(pZtSosikiRn.getZrnnewsosikidenwasigai(),
            pZtSosikiRn.getZrnnewsosikidenwasinai(),pZtSosikiRn.getZrnnewsosikidenwabangou()));
        amSosiki.setHensosikifaxno(editTellNo(pZtSosikiRn.getZrnnewsosikifaxsigai(),
            pZtSosikiRn.getZrnnewsosikifaxsinai(),pZtSosikiRn.getZrnnewsosikifaxbangou()));
        return amSosiki;
    }

    private String editTellNo(String sigai,String sinai,String no) {

        String tellNo = "";

        if (BizUtil.isBlank(sigai)) {
            if (BizUtil.isBlank(sinai)){
                if(BizUtil.isBlank(no)){
                    tellNo = "";
                }else{
                    tellNo = no.trim();
                }
            }else{
                if(BizUtil.isBlank(no)){
                    tellNo = sinai.trim();
                }else{
                    tellNo = sinai.trim().concat("-").concat(no.trim());
                }
            }
        }else{
            if (BizUtil.isBlank(sinai)){
                if(BizUtil.isBlank(no)){
                    tellNo = sigai;
                }else{
                    tellNo = sigai.trim().concat("-").concat(no.trim());
                }
            }else{
                if(BizUtil.isBlank(no)){
                    tellNo = sigai.trim().concat("-").concat(sinai.trim());
                }else{
                    tellNo = sigai.trim().concat("-").concat(sinai.trim()).
                        concat("-").concat(no.trim());
                }
            }
        }
        return tellNo;
    }

}
