package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakutyusyutusi;

import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakutyusyutusi.dba.BzKijituTouraiKeiyakuTyusyutuSiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 システム本番検証用 期日到来契約抽出（保険金）
 */
public class BzKijituTouraiKeiyakuTyusyutuSiBatch implements Batch {

    private static final String SUBSYSTEMID_SIHARAI  = "siharai";

    private static final int TYSYTNO_1 = 1;
    private static final int TYSYTNO_2 = 2;
    private static final int TYSYTNO_3 = 3;
    private static final int TYSYTNO_4 = 4;
    private static final int TYSYTNO_5 = 5;
    private static final int TYSYTNO_6 = 6;
    private static final int TYSYTNO_7 = 7;
    private static final int TYSYTNO_8 = 8;
    private static final int TYSYTNO_9 = 9;

    private BizDate syoriYmd;

    private String sysDateTimeMilli;

    private String kinouId;

    private String userId;

    private HashMap<Integer, Integer> datakanrinoMap = new HashMap<Integer, Integer>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzKijituTouraiKeiyakuTyusyutuSiDao bzkijituTouraiKeiyakuTyusyutuSiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        kinouId = kinou.getKinouId();
        userId = baseUserInfo.getUserId();

        int syoriCount = 0;

        bzkijituTouraiKeiyakuTyusyutuSiDao.delKijituTouraiHonbanKensyouBySyoriYmdSubSystemId(syoriYmd,
            SUBSYSTEMID_SIHARAI);

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                syoriYmd, C_ShrKekkaKbn.SHR);
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {

                JT_SkKihon jtSkKihonEntity = jtSkEntity.getSkKihon();

                if (C_SeikyuuSyubetu.SDSSHR.eq(jtSkKihonEntity.getSeikyuusyubetu())) {
                    continue;
                }

                List<JT_SiDetail> Jt_SiDetailList = jtSkEntity.getSkJiyuus().get(0).getSiDetails();
                String syouhncd = Jt_SiDetailList.get(0).getSyouhncd();

                int henkoukubetu = SyouhinUtil.henkouKubetuHantei(syouhncd);

                if (henkoukubetu == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_1);
                    multipleEntityInserter.add(createEntity(TYSYTNO_1, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (henkoukubetu == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_2);
                    multipleEntityInserter.add(createEntity(TYSYTNO_2, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (henkoukubetu == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_3);
                    multipleEntityInserter.add(createEntity(TYSYTNO_3, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (henkoukubetu == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_7);
                    multipleEntityInserter.add(createEntity(TYSYTNO_7, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (henkoukubetu == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUGO) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_8);
                    multipleEntityInserter.add(createEntity(TYSYTNO_8, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (henkoukubetu == SyouhinUtil.HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_9);
                    multipleEntityInserter.add(createEntity(TYSYTNO_9, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (!jtSkEntity.getMikeikap().isZeroOrOptional()) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_4);
                    multipleEntityInserter.add(createEntity(TYSYTNO_4, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (!jtSkEntity.getZennouseisankgk().isZeroOrOptional()) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_5);
                    multipleEntityInserter.add(createEntity(TYSYTNO_5, datakanrino, jtSkEntity));
                    syoriCount++;
                }

                if (!jtSkEntity.getHaitoukin().isZeroOrOptional()) {
                    String datakanrino =  getDatakanrinoForTysytno(TYSYTNO_6);
                    multipleEntityInserter.add(createEntity(TYSYTNO_6, datakanrino, jtSkEntity));
                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriCount)));
    }

    private BT_KijituTouraiHonbanKensyou createEntity(int pTysytno, String pDatakanrino, JT_Sk pJtSkEntity) {
        BT_KijituTouraiHonbanKensyou kijituTouraiHonbanKensyou = new BT_KijituTouraiHonbanKensyou();

        kijituTouraiHonbanKensyou.setSyoriYmd(syoriYmd);
        kijituTouraiHonbanKensyou.setSubSystemId(SUBSYSTEMID_SIHARAI);
        kijituTouraiHonbanKensyou.setTysytno(pTysytno);
        kijituTouraiHonbanKensyou.setDatakanrino(pDatakanrino);
        kijituTouraiHonbanKensyou.setTysytnaiyou1(pJtSkEntity.getSyono());
        kijituTouraiHonbanKensyou.setTysytnaiyou2(pJtSkEntity.getSkno());
        kijituTouraiHonbanKensyou.setGyoumuKousinKinou(kinouId);
        kijituTouraiHonbanKensyou.setGyoumuKousinsyaId(userId);
        kijituTouraiHonbanKensyou.setGyoumuKousinTime(sysDateTimeMilli);

        BizPropertyInitializer.initialize(kijituTouraiHonbanKensyou);

        return kijituTouraiHonbanKensyou;
    }

    private String getDatakanrinoForTysytno(int pTysytno) {
        int datakanrino;

        Integer tysytno = Integer.valueOf(pTysytno);

        if (datakanrinoMap.containsKey(tysytno)) {
            datakanrino = datakanrinoMap.get(tysytno).intValue() + 1;
        } else {
            datakanrino = 1;
        }
        datakanrinoMap.put(tysytno, Integer.valueOf(datakanrino));

        return String.valueOf(datakanrino);
    }
}
