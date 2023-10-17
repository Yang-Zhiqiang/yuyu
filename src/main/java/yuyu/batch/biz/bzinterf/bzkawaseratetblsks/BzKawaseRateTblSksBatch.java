package yuyu.batch.biz.bzinterf.bzkawaseratetblsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.db.entity.BT_KawaseRateData;
import yuyu.def.db.entity.ZT_KawaserateTr;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

public class BzKawaseRateTblSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final String KAKUTYOUJOBCD_KOUJIKAWASERATE1 = "RGCAD000";

    private final String KAKUTYOUJOBCD_KOUJIKAWASERATE2 = "RGCAD001";

    private final String KAKUTYOUJOBCD_PM17JIKAWASERATE = "RGCAD002";

    private final String KAKUTYOUJOBCD_KOUJIKAWASERATE1_DAI2MAINTENANCE = "RGCAD003";

    private final String KAKUTYOUJOBCD_KOUJIKAWASERATE2_DAI2MAINTENANCE = "RGCAD004";

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        C_KwsrendouKbn rendouKbn;
        if (KAKUTYOUJOBCD_KOUJIKAWASERATE1.equals(kakutyoujobcd)
            || KAKUTYOUJOBCD_KOUJIKAWASERATE1_DAI2MAINTENANCE.equals(kakutyoujobcd)) {
            rendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE1;
        } else if (KAKUTYOUJOBCD_KOUJIKAWASERATE2.equals(kakutyoujobcd)
            || KAKUTYOUJOBCD_KOUJIKAWASERATE2_DAI2MAINTENANCE.equals(kakutyoujobcd)) {
            rendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE2;
        } else if (KAKUTYOUJOBCD_PM17JIKAWASERATE.equals(kakutyoujobcd)) {
            rendouKbn = C_KwsrendouKbn.PM17JIKAWASERATE;
        } else {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0042, kakutyoujobcd));
        }

        ZT_KawaserateTr ztKawaserateTr = zdbDomManager.getKawaserateTr(syoriYmd.toString(), rendouKbn.getValue());

        if(ztKawaserateTr == null) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0048));
        }

        BT_KawaseRateData btKawaserateData = new BT_KawaseRateData();
        btKawaserateData.setKwsratekjymd(syoriYmd);
        btKawaserateData.setKwsrendoukbn(rendouKbn);
        btKawaserateData.setYobiv91(ztKawaserateTr.getZtryobiv91());
        btKawaserateData.setUsdjpytts(ztKawaserateTr.getZtrusdjpytts());
        btKawaserateData.setUsdjpyttb(ztKawaserateTr.getZtrusdjpyttb());
        btKawaserateData.setUsdjpyttm(ztKawaserateTr.getZtrusdjpyttm());
        btKawaserateData.setEurjpytts(ztKawaserateTr.getZtreurjpytts());
        btKawaserateData.setEurjpyttb(ztKawaserateTr.getZtreurjpyttb());
        btKawaserateData.setEurjpyttm(ztKawaserateTr.getZtreurjpyttm());
        btKawaserateData.setAudjpytts(ztKawaserateTr.getZtraudjpytts());
        btKawaserateData.setAudjpyttb(ztKawaserateTr.getZtraudjpyttb());
        btKawaserateData.setAudjpyttm(ztKawaserateTr.getZtraudjpyttm());
        btKawaserateData.setYobin9(ztKawaserateTr.getZtryobin9());
        btKawaserateData.setYobin9x2(ztKawaserateTr.getZtryobin9x2());
        btKawaserateData.setYobin9x3(ztKawaserateTr.getZtryobin9x3());
        btKawaserateData.setYobin9x4(ztKawaserateTr.getZtryobin9x4());
        btKawaserateData.setYobin9x5(ztKawaserateTr.getZtryobin9x5());
        btKawaserateData.setYobin9x6(ztKawaserateTr.getZtryobin9x6());
        btKawaserateData.setYobin9x7(ztKawaserateTr.getZtryobin9x7());
        btKawaserateData.setYobin9x8(ztKawaserateTr.getZtryobin9x8());
        btKawaserateData.setYobin9x9(ztKawaserateTr.getZtryobin9x9());
        btKawaserateData.setYobin9x10(ztKawaserateTr.getZtryobin9x10());
        btKawaserateData.setYobin9x11(ztKawaserateTr.getZtryobin9x11());
        btKawaserateData.setYobin9x12(ztKawaserateTr.getZtryobin9x12());
        btKawaserateData.setYobin9x13(ztKawaserateTr.getZtryobin9x13());
        btKawaserateData.setYobin9x14(ztKawaserateTr.getZtryobin9x14());
        btKawaserateData.setYobin9x15(ztKawaserateTr.getZtryobin9x15());
        btKawaserateData.setYobin9x16(ztKawaserateTr.getZtryobin9x16());
        btKawaserateData.setYobin9x17(ztKawaserateTr.getZtryobin9x17());
        btKawaserateData.setYobin9x18(ztKawaserateTr.getZtryobin9x18());
        btKawaserateData.setYobin9x19(ztKawaserateTr.getZtryobin9x19());
        btKawaserateData.setYobin9x20(ztKawaserateTr.getZtryobin9x20());
        btKawaserateData.setYobin9x21(ztKawaserateTr.getZtryobin9x21());
        btKawaserateData.setUsdjpynykn(ztKawaserateTr.getZtrusdjpynykn());
        btKawaserateData.setEurjpynykn(ztKawaserateTr.getZtreurjpynykn());
        btKawaserateData.setAudjpynykn(ztKawaserateTr.getZtraudjpynykn());
        btKawaserateData.setYobin9x101(ztKawaserateTr.getZtryobin9x101());
        btKawaserateData.setYobin9x102(ztKawaserateTr.getZtryobin9x102());
        btKawaserateData.setYobin9x103(ztKawaserateTr.getZtryobin9x103());
        btKawaserateData.setYobin9x104(ztKawaserateTr.getZtryobin9x104());
        btKawaserateData.setYobin9x105(ztKawaserateTr.getZtryobin9x105());
        btKawaserateData.setYobin9x106(ztKawaserateTr.getZtryobin9x106());
        btKawaserateData.setYobin9x107(ztKawaserateTr.getZtryobin9x107());
        btKawaserateData.setUsdeurnykn(ztKawaserateTr.getZtrusdeurnykn());
        btKawaserateData.setUsdaudnykn(ztKawaserateTr.getZtrusdaudnykn());
        btKawaserateData.setYobin9x111(ztKawaserateTr.getZtryobin9x111());
        btKawaserateData.setYobin9x112(ztKawaserateTr.getZtryobin9x112());
        btKawaserateData.setYobin9x113(ztKawaserateTr.getZtryobin9x113());
        btKawaserateData.setYobin9x114(ztKawaserateTr.getZtryobin9x114());
        btKawaserateData.setYobin9x115(ztKawaserateTr.getZtryobin9x115());
        btKawaserateData.setYobin9x116(ztKawaserateTr.getZtryobin9x116());
        btKawaserateData.setYobin9x117(ztKawaserateTr.getZtryobin9x117());
        btKawaserateData.setEurusdnykn(ztKawaserateTr.getZtreurusdnykn());
        btKawaserateData.setEuraudnykn(ztKawaserateTr.getZtreuraudnykn());
        btKawaserateData.setYobin9x121(ztKawaserateTr.getZtryobin9x121());
        btKawaserateData.setYobin9x122(ztKawaserateTr.getZtryobin9x122());
        btKawaserateData.setYobin9x123(ztKawaserateTr.getZtryobin9x123());
        btKawaserateData.setYobin9x124(ztKawaserateTr.getZtryobin9x124());
        btKawaserateData.setYobin9x125(ztKawaserateTr.getZtryobin9x125());
        btKawaserateData.setYobin9x126(ztKawaserateTr.getZtryobin9x126());
        btKawaserateData.setYobin9x127(ztKawaserateTr.getZtryobin9x127());
        btKawaserateData.setAudusdnykn(ztKawaserateTr.getZtraudusenykn());
        btKawaserateData.setAudeurnykn(ztKawaserateTr.getZtraudeurnykn());
        btKawaserateData.setYobin9x131(ztKawaserateTr.getZtryobin9x131());
        btKawaserateData.setYobin9x132(ztKawaserateTr.getZtryobin9x132());
        btKawaserateData.setYobin9x133(ztKawaserateTr.getZtryobin9x133());
        btKawaserateData.setYobin9x134(ztKawaserateTr.getZtryobin9x134());
        btKawaserateData.setYobin9x135(ztKawaserateTr.getZtryobin9x135());
        btKawaserateData.setYobin9x136(ztKawaserateTr.getZtryobin9x136());
        btKawaserateData.setYobin9x137(ztKawaserateTr.getZtryobin9x137());
        btKawaserateData.setYobin9x141(ztKawaserateTr.getZtryobin9x141());
        btKawaserateData.setYobin9x142(ztKawaserateTr.getZtryobin9x142());
        btKawaserateData.setYobin9x143(ztKawaserateTr.getZtryobin9x143());
        btKawaserateData.setYobin9x144(ztKawaserateTr.getZtryobin9x144());
        btKawaserateData.setYobin9x145(ztKawaserateTr.getZtryobin9x145());
        btKawaserateData.setYobin9x146(ztKawaserateTr.getZtryobin9x146());
        btKawaserateData.setYobin9x147(ztKawaserateTr.getZtryobin9x147());
        btKawaserateData.setYobin9x148(ztKawaserateTr.getZtryobin9x148());
        btKawaserateData.setYobin9x149(ztKawaserateTr.getZtryobin9x149());
        btKawaserateData.setYobin9x151(ztKawaserateTr.getZtryobin9x151());
        btKawaserateData.setYobin9x152(ztKawaserateTr.getZtryobin9x152());
        btKawaserateData.setYobin9x153(ztKawaserateTr.getZtryobin9x153());
        btKawaserateData.setYobin9x154(ztKawaserateTr.getZtryobin9x154());
        btKawaserateData.setYobin9x155(ztKawaserateTr.getZtryobin9x155());
        btKawaserateData.setYobin9x156(ztKawaserateTr.getZtryobin9x156());
        btKawaserateData.setYobin9x157(ztKawaserateTr.getZtryobin9x157());
        btKawaserateData.setYobin9x158(ztKawaserateTr.getZtryobin9x158());
        btKawaserateData.setYobin9x159(ztKawaserateTr.getZtryobin9x159());
        btKawaserateData.setYobin9x161(ztKawaserateTr.getZtryobin9x161());
        btKawaserateData.setYobin9x162(ztKawaserateTr.getZtryobin9x162());
        btKawaserateData.setYobin9x163(ztKawaserateTr.getZtryobin9x163());
        btKawaserateData.setYobin9x164(ztKawaserateTr.getZtryobin9x164());
        btKawaserateData.setYobin9x165(ztKawaserateTr.getZtryobin9x165());
        btKawaserateData.setYobin9x166(ztKawaserateTr.getZtryobin9x166());
        btKawaserateData.setYobin9x167(ztKawaserateTr.getZtryobin9x167());
        btKawaserateData.setYobin9x168(ztKawaserateTr.getZtryobin9x168());
        btKawaserateData.setYobin9x169(ztKawaserateTr.getZtryobin9x169());
        btKawaserateData.setYobin9x171(ztKawaserateTr.getZtryobin9x171());
        btKawaserateData.setYobin9x172(ztKawaserateTr.getZtryobin9x172());
        btKawaserateData.setYobin9x173(ztKawaserateTr.getZtryobin9x173());
        btKawaserateData.setYobin9x174(ztKawaserateTr.getZtryobin9x174());
        btKawaserateData.setYobin9x175(ztKawaserateTr.getZtryobin9x175());
        btKawaserateData.setYobin9x176(ztKawaserateTr.getZtryobin9x176());
        btKawaserateData.setYobin9x177(ztKawaserateTr.getZtryobin9x177());
        btKawaserateData.setYobin9x178(ztKawaserateTr.getZtryobin9x178());
        btKawaserateData.setYobin9x179(ztKawaserateTr.getZtryobin9x179());
        btKawaserateData.setYobin9x181(ztKawaserateTr.getZtryobin9x181());
        btKawaserateData.setYobin9x182(ztKawaserateTr.getZtryobin9x182());
        btKawaserateData.setYobin9x183(ztKawaserateTr.getZtryobin9x183());
        btKawaserateData.setYobin9x184(ztKawaserateTr.getZtryobin9x184());
        btKawaserateData.setYobin9x185(ztKawaserateTr.getZtryobin9x185());
        btKawaserateData.setYobin9x186(ztKawaserateTr.getZtryobin9x186());
        btKawaserateData.setYobin9x187(ztKawaserateTr.getZtryobin9x187());
        btKawaserateData.setYobin9x188(ztKawaserateTr.getZtryobin9x188());
        btKawaserateData.setYobin9x189(ztKawaserateTr.getZtryobin9x189());
        btKawaserateData.setYobin9x191(ztKawaserateTr.getZtryobin9x191());
        btKawaserateData.setYobin9x192(ztKawaserateTr.getZtryobin9x192());
        btKawaserateData.setYobin9x193(ztKawaserateTr.getZtryobin9x193());
        btKawaserateData.setYobin9x194(ztKawaserateTr.getZtryobin9x194());
        btKawaserateData.setYobin9x195(ztKawaserateTr.getZtryobin9x195());
        btKawaserateData.setYobin9x196(ztKawaserateTr.getZtryobin9x196());
        btKawaserateData.setYobin9x197(ztKawaserateTr.getZtryobin9x197());
        btKawaserateData.setYobin9x198(ztKawaserateTr.getZtryobin9x198());
        btKawaserateData.setYobin9x199(ztKawaserateTr.getZtryobin9x199());
        btKawaserateData.setYobin9x201(ztKawaserateTr.getZtryobin9x201());
        btKawaserateData.setYobin9x202(ztKawaserateTr.getZtryobin9x202());
        btKawaserateData.setYobin9x203(ztKawaserateTr.getZtryobin9x203());
        btKawaserateData.setYobin9x204(ztKawaserateTr.getZtryobin9x204());
        btKawaserateData.setYobin9x205(ztKawaserateTr.getZtryobin9x205());
        btKawaserateData.setYobin9x206(ztKawaserateTr.getZtryobin9x206());
        btKawaserateData.setYobin9x207(ztKawaserateTr.getZtryobin9x207());
        btKawaserateData.setYobin9x208(ztKawaserateTr.getZtryobin9x208());
        btKawaserateData.setYobin9x209(ztKawaserateTr.getZtryobin9x209());
        btKawaserateData.setUsdjpysykn(ztKawaserateTr.getZtrusdjpysykn());
        btKawaserateData.setEurjpysykn(ztKawaserateTr.getZtreurjpysykn());
        btKawaserateData.setAudjpysykn(ztKawaserateTr.getZtraudjpysykn());
        btKawaserateData.setYobin9x301(ztKawaserateTr.getZtryobin9x301());
        btKawaserateData.setYobin9x302(ztKawaserateTr.getZtryobin9x302());
        btKawaserateData.setYobin9x303(ztKawaserateTr.getZtryobin9x303());
        btKawaserateData.setYobin9x304(ztKawaserateTr.getZtryobin9x304());
        btKawaserateData.setYobin9x305(ztKawaserateTr.getZtryobin9x305());
        btKawaserateData.setYobin9x306(ztKawaserateTr.getZtryobin9x306());
        btKawaserateData.setYobin9x307(ztKawaserateTr.getZtryobin9x307());
        btKawaserateData.setUsdjpytts17pm(ztKawaserateTr.getZtrusdjpytts17pm());
        btKawaserateData.setUsdjpyttb17pm(ztKawaserateTr.getZtrusdjpyttb17pm());
        btKawaserateData.setUsdjpyttm17pm(ztKawaserateTr.getZtrusdjpyttm17pm());
        btKawaserateData.setEurjpytts17pm(ztKawaserateTr.getZtreurjpytts17pm());
        btKawaserateData.setEurjpyttb17pm(ztKawaserateTr.getZtreurjpyttb17pm());
        btKawaserateData.setEurjpyttm17pm(ztKawaserateTr.getZtreurjpyttm17pm());
        btKawaserateData.setAudjpytts17pm(ztKawaserateTr.getZtraudjpytts17pm());
        btKawaserateData.setAudjpyttb17pm(ztKawaserateTr.getZtraudjpyttb17pm());
        btKawaserateData.setAudjpyttm17pm(ztKawaserateTr.getZtraudjpyttm17pm());
        btKawaserateData.setYobin9x501(ztKawaserateTr.getZtryobin9x501());
        btKawaserateData.setYobin9x502(ztKawaserateTr.getZtryobin9x502());
        btKawaserateData.setYobin9x503(ztKawaserateTr.getZtryobin9x503());
        btKawaserateData.setYobin9x504(ztKawaserateTr.getZtryobin9x504());
        btKawaserateData.setYobin9x505(ztKawaserateTr.getZtryobin9x505());
        btKawaserateData.setYobin9x506(ztKawaserateTr.getZtryobin9x506());
        btKawaserateData.setYobin9x507(ztKawaserateTr.getZtryobin9x507());
        btKawaserateData.setYobin9x508(ztKawaserateTr.getZtryobin9x508());
        btKawaserateData.setYobin9x509(ztKawaserateTr.getZtryobin9x509());
        btKawaserateData.setYobin9x510(ztKawaserateTr.getZtryobin9x510());
        btKawaserateData.setYobin9x511(ztKawaserateTr.getZtryobin9x511());
        btKawaserateData.setYobin9x512(ztKawaserateTr.getZtryobin9x512());
        btKawaserateData.setYobin9x513(ztKawaserateTr.getZtryobin9x513());
        btKawaserateData.setYobin9x514(ztKawaserateTr.getZtryobin9x514());
        btKawaserateData.setYobin9x515(ztKawaserateTr.getZtryobin9x515());
        btKawaserateData.setYobin9x516(ztKawaserateTr.getZtryobin9x516());
        btKawaserateData.setYobin9x517(ztKawaserateTr.getZtryobin9x517());
        btKawaserateData.setYobin9x518(ztKawaserateTr.getZtryobin9x518());
        btKawaserateData.setYobin9x519(ztKawaserateTr.getZtryobin9x519());
        btKawaserateData.setYobin9x520(ztKawaserateTr.getZtryobin9x520());
        btKawaserateData.setYobin9x521(ztKawaserateTr.getZtryobin9x521());

        bizDomManager.insert(btKawaserateData);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(1)));
    }
}
