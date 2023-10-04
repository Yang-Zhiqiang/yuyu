package yuyu.batch.hozen.khinterf.khsyoumetutuutifilesks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khsyoumetutuutifilesks.dba.KhSyometuTuutiDataBean;
import yuyu.batch.hozen.khinterf.khsyoumetutuutifilesks.dba.KhSyoumetuTuutiFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_SyoumetuTuuti;
import yuyu.def.db.entity.ZT_SyoumetuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェース 消滅通知Ｆ作成
 */
public class KhSyoumetuTuutiFileSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_SyoumetuTuuti.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSyoumetuTuutiFileSksDao khSyoumetuTuutiFileSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        long syoriKensuu = 0;
        AM_SyoruiZokusei syoruiZokusei = baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.AS_SYOUMETUTUUTI_SHRSKS);
        int syoumetuTuutiHozonKikan = syoruiZokusei.getHozonKikan();

        try (ExDBResults<KhSyometuTuutiDataBean> khTmttkingkYskSelBeanLst = khSyoumetuTuutiFileSksDao
            .getSyometuTuutiDataBeans(bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());
            EntityInserter<ZT_SyoumetuTuutiTy> syoumetuTuutiTyInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanInserter = new EntityInserter<>();) {
            for (KhSyometuTuutiDataBean khSyometuTuutiDataBean : khTmttkingkYskSelBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khSyometuTuutiDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khSyometuTuutiDataBean.getSyono());
                String tyouhyouYmd = "";
                C_TantousituKbn tantousituKbn = C_TantousituKbn.BLNK;
                C_UmuKbn kawaserateMongonUmuKbn = C_UmuKbn.NONE;
                String aisatuMongon1 = "";
                String aisatuMongon2 = "";
                String aisatuMongon3 = "";
                String aisatuMongon4 = "";
                String aisatuMongon5 = "";
                String aisatuMongon6 = "";
                String kyknm = "";
                String keiyakuymd = "";
                String hknsyrui = "";
                String syoumetuYmd = "";
                String haraimodosikn = "";
                String shrYmd = "";
                List<String> tekiyouLst = new ArrayList<>();
                List<C_HugouKbn> meisaihugouLst = new ArrayList<>();
                List<BizCurrency> kngkmeisaiLst = new ArrayList<>();
                List<C_Tuukasyu> kngkmisituukasyuLst = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    tekiyouLst.add("");
                    meisaihugouLst.add(C_HugouKbn.SEI);
                    kngkmeisaiLst.add(BizCurrency.valueOf(0));
                    kngkmisituukasyuLst.add(C_Tuukasyu.BLNK);
                }

                List<String> bikouLst = new ArrayList<>();
                for (int j = 0; j < 7; j++) {
                    bikouLst.add("");
                }
                BizCurrency shrgkgoukei = BizCurrency.valueOf(0);
                String shrTuukasyu = "";
                String shrNaiyouHskmongon1 = "";
                String banknmkj = "";
                String sitennmkj = "";
                C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
                String kouzaNo = "";
                String kzmeiginmkn = "";
                C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.BLNK;
                String synykngk = "";
                C_Tuukasyu synykngkTuukasyu = C_Tuukasyu.BLNK;
                String htykeihi = "";
                C_Tuukasyu htykeihiTuukasyu = C_Tuukasyu.BLNK;
                String shrKyksyahtykeihi = "";
                C_Tuukasyu shrKyksyahtykeihiTuukasyu = C_Tuukasyu.BLNK;
                C_ZeimuNaiyouHnsyuCtrlKbn zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.BLNK;
                C_UmuKbn zeimumongonoutKbn = C_UmuKbn.NONE;
                String zeimumongon1 = "";
                String zeimumongon2 = "";
                String zeimumongon3 = "";
                String sirasehyoudai = "";
                List<String> osirasemongonLst = new ArrayList<>();
                for (int k = 0; k < 26; k++) {
                    osirasemongonLst.add("");
                }
                String teisyutusrmongon1 = "";
                String teisyutusrmongon2 = "";
                String teisyutusrmongon3 = "";
                String seikyuusyasyomeimongon1 = "";
                String seikyuusyasyomeimongon2 = "";
                String seikyuusyasyomeimongon3 = "";
                String seikyuusyagenyno = "";
                String seikyuusyagenadr1 = "";
                String seikyuusyagenadr2 = "";
                String seikyuusyagenadr3 = "";
                String seikyuuyagentelno = "";
                String hozonKikan = "";
                String teisyutusrmongon4 = "";
                int shrdetailIndex = 0;
                int siraseIndex = 0;
                tyouhyouYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khSyometuTuutiDataBean.getTyouhyouymd());
                syoumetuYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khSyometuTuutiDataBean.getSyoumetuymd());
                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(khSyometuTuutiDataBean.getSyono());
                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
                keiyakuymd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykSyouhn.getKykymd());
                if (C_SyoruiCdKbn.AS_SYOUMETUTUUTI.eq(khSyometuTuutiDataBean.getSyoruiCd())) {
                    tantousituKbn = C_TantousituKbn.SYUUNOUSV;
                    shrYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khSyometuTuutiDataBean.getShrymd());
                    aisatuMongon1 = "いつもお引立ていただきありがとうございます。";
                    aisatuMongon4 = "なお、ご契約には、以下のとおり、お払戻金がございます。";
                    aisatuMongon5 = "当社にご登録いただいておりました下記口座へお支払いさせていただきます。";
                    aisatuMongon6 = "あらかじめご了承ください。ご請求に必要なお手続きは不要です。";
                    if(C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())){
                        aisatuMongon2 = "以下のご契約につきましては、保険料のお払込みがないまま保険料払込みの";
                        aisatuMongon3 = "猶予期間を経過したため、ご契約が消滅しております。";
                    }
                    else{
                        aisatuMongon2 = "以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保険料払込み";
                        aisatuMongon3 = "の猶予期間を経過したため、ご契約が消滅しております。";
                    }

                    kyknm = khSyometuTuutiDataBean.getKyknmkj();
                    tekiyouLst.set(shrdetailIndex, "解約返戻金");
                    meisaihugouLst.set(shrdetailIndex, C_HugouKbn.SEI);
                    kngkmeisaiLst.set(shrdetailIndex, khSyometuTuutiDataBean.getShrtuukakaiyakuhrkngkkei());
                    kngkmisituukasyuLst.set(shrdetailIndex, khSyometuTuutiDataBean.getShrtuukasyu());
                    if (khSyometuTuutiDataBean.getYenkansanhaitoukin().compareTo(BizCurrency.valueOf(0,
                        khSyometuTuutiDataBean.getYenkansanhaitoukin().getType())) > 0) {
                        shrdetailIndex = shrdetailIndex + 1;
                        tekiyouLst.set(shrdetailIndex, "配当金");
                        meisaihugouLst.set(shrdetailIndex, C_HugouKbn.SEI);
                        kngkmeisaiLst.set(shrdetailIndex, khSyometuTuutiDataBean.getYenkansanhaitoukin());
                        kngkmisituukasyuLst.set(shrdetailIndex, khSyometuTuutiDataBean.getShrtuukasyu());
                    }
                    if (khSyometuTuutiDataBean.getYensonotahaitoukin().compareTo(BizCurrency.valueOf(0,
                        khSyometuTuutiDataBean.getYensonotahaitoukin().getType())) > 0) {
                        shrdetailIndex = shrdetailIndex + 1;
                        tekiyouLst.set(shrdetailIndex, "特別配当金");
                        meisaihugouLst.set(shrdetailIndex, C_HugouKbn.SEI);
                        kngkmeisaiLst.set(shrdetailIndex, khSyometuTuutiDataBean.getYensonotahaitoukin());
                        kngkmisituukasyuLst.set(shrdetailIndex, khSyometuTuutiDataBean.getShrtuukasyu());
                    }
                    if (khSyometuTuutiDataBean.getSonotaseisan().compareTo(BizCurrency.valueOf(0,
                        khSyometuTuutiDataBean.getSonotaseisan().getType())) > 0) {
                        shrdetailIndex = shrdetailIndex + 1;
                        tekiyouLst.set(shrdetailIndex, "その他精算金");
                        meisaihugouLst.set(shrdetailIndex, C_HugouKbn.SEI);
                        kngkmeisaiLst.set(shrdetailIndex, khSyometuTuutiDataBean.getSonotaseisan());
                        kngkmisituukasyuLst.set(shrdetailIndex, khSyometuTuutiDataBean.getShrtuukasyu());
                    }
                    String shrkwsrateZenkaku = ConvertUtil.toZenAll(
                        BizUtil.comma(khSyometuTuutiDataBean.getShrkwsrate().toString(), BizUtil.ZERO_FILL, 2), 0, 0);
                    String kaiyakuhrkngkkeiSiteituuka = ConvertUtil.toZenAll(ViewReport.editCommaTuuka(
                        khSyometuTuutiDataBean.getKaiyakuhrkngkkeisiteituuka(), BizUtil.ZERO_FILL), 0, 0);

                    if(!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())){
                        int syouhinUtilKekka = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
                        if(syouhinUtilKekka == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
                            bikouLst.set(0, "・解約返戻金＝（１）×（２）");
                            bikouLst.set(1, "（１）適用為替レート：" + shrkwsrateZenkaku + "円");
                            bikouLst.set(2, "（２）解約返戻金");
                            bikouLst.set(3, "　　　" + kaiyakuhrkngkkeiSiteituuka);
                        }
                        else{
                            if (khSyometuTuutiDataBean.getZitkazukarikingksiteituuka().compareTo(BizCurrency.valueOf(0,
                                khSyometuTuutiDataBean.getZitkazukarikingksiteituuka().getType())) > 0) {
                                String zitkazukarikingkSiteituuka = ConvertUtil.toZenAll(
                                    ViewReport.editCommaTuuka(khSyometuTuutiDataBean.getZitkazukarikingksiteituuka(), BizUtil.ZERO_FILL), 0, 0);
                                bikouLst.set(0, "・解約返戻金＝（１）×（２）");
                                bikouLst.set(1, "（１）適用為替レート：" + shrkwsrateZenkaku + "円");
                                bikouLst.set(2, "（２）解約返戻金");
                                bikouLst.set(3, "　　　" + kaiyakuhrkngkkeiSiteituuka);
                                bikouLst.set(4, "　　上記解約返戻金には以下の契約変更時返戻金（注）");
                                bikouLst.set(5, "　　を含みます。");
                                bikouLst.set(6, "　　　" + zitkazukarikingkSiteituuka);
                            }
                            else {
                                bikouLst.set(0, "・解約返戻金＝（１）×（２）");
                                bikouLst.set(1, "（１）適用為替レート：" + shrkwsrateZenkaku + "円");
                                bikouLst.set(2, "（２）解約返戻金");
                                bikouLst.set(3, "　　　" + kaiyakuhrkngkkeiSiteituuka);
                            }
                        }
                    }

                    shrgkgoukei = khSyometuTuutiDataBean.getShrgkkei();
                    shrTuukasyu = khSyometuTuutiDataBean.getShrtuukasyu().getValue();
                    if (khSyometuTuutiDataBean.getZitkazukarikingksiteituuka().compareTo(BizCurrency.valueOf(0,
                        khSyometuTuutiDataBean.getZitkazukarikingksiteituuka().getType())) > 0) {
                        shrNaiyouHskmongon1 = "（注）個人年金保険料税制適格特約（’９０）付加のため、契約変更時にお預かりしていた返戻金";
                    }
                    kouzaNo = KhozenEdit.editKouzaNo(khSyometuTuutiDataBean.getBankcd(), khSyometuTuutiDataBean.getKouzano());
                    banknmkj = khSyometuTuutiDataBean.getBanknmkj();
                    sitennmkj = khSyometuTuutiDataBean.getSitennmkj();
                    yokinKbn = khSyometuTuutiDataBean.getYokinkbn();
                    kzmeiginmkn = khSyometuTuutiDataBean.getKzmeiginmkn();
                    kouzasyuruiKbn = khSyometuTuutiDataBean.getKzsyuruikbn();
                    synykngk = khSyometuTuutiDataBean.getSynykngk().toString();
                    synykngkTuukasyu = C_Tuukasyu.JPY;
                    htykeihi = khSyometuTuutiDataBean.getHtykeihi().toString();
                    htykeihiTuukasyu = C_Tuukasyu.JPY;
                    zeimuNaiyouHnsyuCtrlKbn = khSyometuTuutiDataBean.getZeimunaiyouhensyuctrlkbn();
                    String syotokuNen = FixedDateFormatter.formatYZenkakuSeirekiKanji(khSyometuTuutiDataBean.getSyoumetuymd());
                    if (khSyometuTuutiDataBean.getKykhnkkaisuu() == 0) {
                        zeimumongonoutKbn = C_UmuKbn.ARI;
                        zeimumongon1 = "※" + syotokuNen + "の所得となります。";
                    }
                    else {
                        shrKyksyahtykeihi = khSyometuTuutiDataBean.getShrkykhtykeihi().toString();
                        shrKyksyahtykeihiTuukasyu = C_Tuukasyu.JPY;
                        zeimumongonoutKbn = C_UmuKbn.ARI;
                        zeimumongon1 = "※" + syotokuNen + "の所得となります。";
                        zeimumongon2 = "※ご契約期間中に契約者の変更がありました。";
                        zeimumongon3 = "　確定申告については所轄の税務署にお問い合わせください。";
                    }
                    if(C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())){
                        sirasehyoudai = "「ご契約に関するお知らせ」について";
                        osirasemongonLst.set(siraseIndex++, "【お支払内容について】");
                        osirasemongonLst.set(siraseIndex++, "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。");
                        osirasemongonLst.set(siraseIndex++, "");
                        osirasemongonLst.set(siraseIndex++, "");
                        osirasemongonLst.set(siraseIndex++, "");
                    }
                    else{
                        sirasehyoudai = "「ご契約に関するお知らせ」について";
                        osirasemongonLst.set(siraseIndex++, "【お支払内容について】");
                        osirasemongonLst.set(siraseIndex++, "　◆お払戻金は、解約返戻金を消滅日の当社所定の為替レート（※１）で円に換算した金額です。");
                        osirasemongonLst.set(siraseIndex++, "　◆当社所定の為替レート（※１）は、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」");
                        osirasemongonLst.set(siraseIndex++, "　　（※３）となります。");
                        osirasemongonLst.set(siraseIndex++, "　　（※１）当社所定の為替レートは、住友生命ホームページにてご確認いただけます。消滅日が当社が指標とし");
                        osirasemongonLst.set(siraseIndex++, "　　　　　　て指定する金融機関の休業日の場合は、その日の直後に到来する金融機関の営業日の為替レートとしま");
                        osirasemongonLst.set(siraseIndex++, "　　　　　　す。");
                        osirasemongonLst.set(siraseIndex++, "　　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電信買");
                        osirasemongonLst.set(siraseIndex++, "　　　　　　相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の公示値とし");
                        osirasemongonLst.set(siraseIndex++, "　　　　　　ます。当社が指標として指定する金融機関が、その営業日においてＴＴＳ・ＴＴＢを公示しない場合に");
                        osirasemongonLst.set(siraseIndex++, "　　　　　　は、上記と異なる為替レートに変更することがあります。");
                        osirasemongonLst.set(siraseIndex++, "　　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。");
                        osirasemongonLst.set(siraseIndex++, "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。");
                        osirasemongonLst.set(siraseIndex++, "");
                        osirasemongonLst.set(siraseIndex++, "");
                        osirasemongonLst.set(siraseIndex++, "");
                    }
                    if (khSyometuTuutiDataBean.getKykhnkkaisuu() == 0) {
                        osirasemongonLst.set(siraseIndex++, "【返戻金に対する税務のご説明】");
                        osirasemongonLst.set(siraseIndex++, "　◆消滅日の属する年の所得となります。");
                        osirasemongonLst.set(siraseIndex++, "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
                        osirasemongonLst.set(siraseIndex++, "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
                        osirasemongonLst.set(siraseIndex++, "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
                        osirasemongonLst.set(siraseIndex++, "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
                        osirasemongonLst.set(siraseIndex++, "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
                        osirasemongonLst.set(siraseIndex++, "　◆収入金額、必要経費は「ご契約に関するお知らせ」に記載のとおりです。「ご契約に関するお知らせ」");
                        osirasemongonLst.set(siraseIndex++, "　　は、確定申告の際の参考資料になりますので、大切に保管してください。");
                    }
                    else {
                        osirasemongonLst.set(siraseIndex++, "【返戻金に対する税務のご説明】");
                        osirasemongonLst.set(siraseIndex++, "　◆消滅日の属する年の所得となります。");
                        osirasemongonLst.set(siraseIndex++, "　◆「ご契約に関するお知らせ」は、確定申告の際の参考資料になりますので、大切に保管してください。");
                        osirasemongonLst.set(siraseIndex++, "　◆既払込保険料等は既に払い込まれた円貨払込額の合計額等です。");
                    }
                    if (C_HtsiryosyuKbn.ITJKNSHRTYOUSYO.eq(khSyometuTuutiDataBean.getHtsiryosyukbn())) {
                        osirasemongonLst.set(siraseIndex++, "　◆所轄の税務署あてに、支払調書を提出しています。");

                    }

                }
                else if (C_SyoruiCdKbn.AS_SYOUMETUTUUTI_SHRSKS.eq(khSyometuTuutiDataBean.getSyoruiCd())) {
                    tantousituKbn = C_TantousituKbn.HOZENSIHARAISV;

                    if(C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())){
                        kawaserateMongonUmuKbn = C_UmuKbn.NONE;
                    }
                    else{
                        kawaserateMongonUmuKbn = C_UmuKbn.ARI;
                    }
                    aisatuMongon1 = "いつもお引立てをいただきありがとうございます。";
                    aisatuMongon4 = "なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続";
                    aisatuMongon5 = "きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま";
                    aisatuMongon6 = "すようお願い申し上げます。";

                    if(C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())){
                        aisatuMongon2 = "以下のご契約につきましては、保険料のお払込みがないまま保険料払込みの猶";
                        aisatuMongon3 = "予期間を経過したため、ご契約が消滅しております。";
                    }
                    else{
                        aisatuMongon2 = "以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保";
                        aisatuMongon3 = "険料払込みの猶予期間を経過したため、ご契約が消滅しております。";
                    }
                    BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                        kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());
                    hknsyrui = syouhnZokusei.getSyouhnnmsyouken();
                    haraimodosikn = khSyometuTuutiDataBean.getShrgkkei().toString();
                    if (C_KykMsnKbn.MISEINEN.eq(khSyometuTuutiDataBean.getKykmsnkbn())) {
                        teisyutusrmongon1 = "＊請求者さまが未成年のときは、親権者さまが請求書の親権者欄にご記入ください。";
                        teisyutusrmongon3 = "＊請求者さまが未成年のときは、親権者さまの本人確認書類をご提出ください。";
                    }
                    if (khSyometuTuutiDataBean.getLastsyosaihkymd() != null) {
                        teisyutusrmongon2 = "【再発行年月日　" +
                            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khSyometuTuutiDataBean.getLastsyosaihkymd()) + "】";
                    }
                    if (C_UmuKbn.ARI.eq(khSyometuTuutiDataBean.getMynosinkokuiraidoufuukbn())) {
                        teisyutusrmongon4 = "　また、このお手続きとあわせてマイナンバーのご提供をお願いしております。";
                    }
                    seikyuusyasyomeimongon1 = khSyometuTuutiDataBean.getKyknmkj() + "　様がご記入ください";
                    seikyuusyasyomeimongon2 = "（成年後見人が手続きする場合は成年後見人がご記入ください）";
                    seikyuusyasyomeimongon3 =  "下記の個人情報取り扱いを確認のうえ請求します";
                    seikyuusyagenyno = khSyometuTuutiDataBean.getTsinyno();
                    seikyuusyagenadr1 = khSyometuTuutiDataBean.getTsinadr1kj();
                    seikyuusyagenadr2 = khSyometuTuutiDataBean.getTsinadr2kj();
                    seikyuusyagenadr3 = khSyometuTuutiDataBean.getTsinadr3kj();
                    seikyuuyagentelno = khSyometuTuutiDataBean.getTsintelno();
                    hozonKikan = String.valueOf(syoumetuTuutiHozonKikan);
                }
                ZT_SyoumetuTuutiTy syoumetuTuutiTy = new ZT_SyoumetuTuutiTy();
                syoumetuTuutiTy.setZtysyoruicd(khSyometuTuutiDataBean.getSyoruiCd().getValue().toUpperCase());
                syoumetuTuutiTy.setZtytyouhyouymd(khSyometuTuutiDataBean.getTyouhyouymd().toString());
                syoumetuTuutiTy.setZtytyouhyouymdkj(tyouhyouYmd);
                syoumetuTuutiTy.setZtysyono(khSyometuTuutiDataBean.getSyono());
                syoumetuTuutiTy.setZtyhassoukbn(khSyometuTuutiDataBean.getHassoukbn().getValue());
                syoumetuTuutiTy.setZtytantousitukbn(tantousituKbn.getValue());
                syoumetuTuutiTy.setZtysksdoufuukbn(khSyometuTuutiDataBean.getSksdoufuukbn().getValue());
                syoumetuTuutiTy.setZtymynosinkokuiraidoufuukbn(khSyometuTuutiDataBean.getMynosinkokuiraidoufuukbn().getValue());
                syoumetuTuutiTy.setZtysikibetuno(khSyometuTuutiDataBean.getHenkousikibetukey());
                syoumetuTuutiTy.setZtykwsratemongonumukbn(kawaserateMongonUmuKbn.getValue());
                syoumetuTuutiTy.setZtyshskyno(khSyometuTuutiDataBean.getShskyno());
                syoumetuTuutiTy.setZtyshskadr1kj(khSyometuTuutiDataBean.getShsadr1kj());
                syoumetuTuutiTy.setZtyshskadr2kj(khSyometuTuutiDataBean.getShsadr2kj());
                syoumetuTuutiTy.setZtyshskadr3kj(khSyometuTuutiDataBean.getShsadr3kj());
                syoumetuTuutiTy.setZtyshsnmkj(khSyometuTuutiDataBean.getShsnmkj());
                syoumetuTuutiTy.setZtytawyno(khSyometuTuutiDataBean.getToiawaseyno());
                syoumetuTuutiTy.setZtytawadr1kj(khSyometuTuutiDataBean.getToiawaseadr1kj());
                syoumetuTuutiTy.setZtytawadr2kj(khSyometuTuutiDataBean.getToiawaseadr2kj());
                syoumetuTuutiTy.setZtytawadr3kj(khSyometuTuutiDataBean.getToiawaseadr3kj());
                syoumetuTuutiTy.setZtytoiawasekaisyanmkj(khSyometuTuutiDataBean.getToiawasekaisyanmkj());
                syoumetuTuutiTy.setZtytawsosikikj(khSyometuTuutiDataBean.getToiawasesosikinmkj());
                syoumetuTuutiTy.setZtytawtelnov14(khSyometuTuutiDataBean.getToiawasetelno());
                syoumetuTuutiTy.setZtytawteluktkkanou1x18keta(khSyometuTuutiDataBean.getToiawaseteluktkkanou1());
                syoumetuTuutiTy.setZtytawteluktkkanou2x18keta(khSyometuTuutiDataBean.getToiawaseteluktkkanou2());
                syoumetuTuutiTy.setZtyaisatumongon50keta1(aisatuMongon1);
                syoumetuTuutiTy.setZtyaisatumongon50keta2(aisatuMongon2);
                syoumetuTuutiTy.setZtyaisatumongon50keta3(aisatuMongon3);
                syoumetuTuutiTy.setZtyaisatumongon50keta4(aisatuMongon4);
                syoumetuTuutiTy.setZtyaisatumongon50keta5(aisatuMongon5);
                syoumetuTuutiTy.setZtyaisatumongon50keta6(aisatuMongon6);
                syoumetuTuutiTy.setZtysyono2(khSyometuTuutiDataBean.getSyono());
                syoumetuTuutiTy.setZtykyknmkj(kyknm);
                syoumetuTuutiTy.setZtyhhknnmkj(khSyometuTuutiDataBean.getHhknnmkj());
                syoumetuTuutiTy.setZtykykymdseireki(keiyakuymd);
                syoumetuTuutiTy.setZtyhknsyurui30keta(hknsyrui);
                syoumetuTuutiTy.setZtysyoumetuymd(syoumetuYmd);
                syoumetuTuutiTy.setZtyoharaimodosikn(haraimodosikn);
                syoumetuTuutiTy.setZtyshrymd11keta(shrYmd);
                syoumetuTuutiTy.setZtytekiyou1(tekiyouLst.get(0));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou1(meisaihugouLst.get(0).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai1(editGaikakngk(kngkmeisaiLst.get(0)));
                syoumetuTuutiTy.setZtyshrgktuukasyu1(formatTuukasyuBlank(kngkmisituukasyuLst.get(0)));
                syoumetuTuutiTy.setZtybikou1(bikouLst.get(0));
                syoumetuTuutiTy.setZtytekiyou2(tekiyouLst.get(1));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou2(meisaihugouLst.get(1).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai2(editGaikakngk(kngkmeisaiLst.get(1)));
                syoumetuTuutiTy.setZtyshrgktuukasyu2(formatTuukasyuBlank(kngkmisituukasyuLst.get(1)));
                syoumetuTuutiTy.setZtybikou2(bikouLst.get(1));
                syoumetuTuutiTy.setZtytekiyou3(tekiyouLst.get(2));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou3(meisaihugouLst.get(2).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai3(editGaikakngk(kngkmeisaiLst.get(2)));
                syoumetuTuutiTy.setZtyshrgktuukasyu3(formatTuukasyuBlank(kngkmisituukasyuLst.get(2)));
                syoumetuTuutiTy.setZtybikou3(bikouLst.get(2));
                syoumetuTuutiTy.setZtytekiyou4(tekiyouLst.get(3));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou4(meisaihugouLst.get(3).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai4(editGaikakngk(kngkmeisaiLst.get(3)));
                syoumetuTuutiTy.setZtyshrgktuukasyu4(formatTuukasyuBlank(kngkmisituukasyuLst.get(3)));
                syoumetuTuutiTy.setZtybikou4(bikouLst.get(3));
                syoumetuTuutiTy.setZtytekiyou5(tekiyouLst.get(4));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou5(meisaihugouLst.get(4).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai5(editGaikakngk(kngkmeisaiLst.get(4)));
                syoumetuTuutiTy.setZtyshrgktuukasyu5(formatTuukasyuBlank(kngkmisituukasyuLst.get(4)));
                syoumetuTuutiTy.setZtybikou5(bikouLst.get(4));
                syoumetuTuutiTy.setZtytekiyou6(tekiyouLst.get(5));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou6(meisaihugouLst.get(5).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai6(editGaikakngk(kngkmeisaiLst.get(5)));
                syoumetuTuutiTy.setZtyshrgktuukasyu6(formatTuukasyuBlank(kngkmisituukasyuLst.get(5)));
                syoumetuTuutiTy.setZtybikou6(bikouLst.get(5));
                syoumetuTuutiTy.setZtytekiyou7(tekiyouLst.get(6));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou7(meisaihugouLst.get(6).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai7(editGaikakngk(kngkmeisaiLst.get(6)));
                syoumetuTuutiTy.setZtyshrgktuukasyu7(formatTuukasyuBlank(kngkmisituukasyuLst.get(6)));
                syoumetuTuutiTy.setZtybikou7(bikouLst.get(6));
                syoumetuTuutiTy.setZtytekiyou8(tekiyouLst.get(7));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou8(meisaihugouLst.get(7).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai8(editGaikakngk(kngkmeisaiLst.get(7)));
                syoumetuTuutiTy.setZtyshrgktuukasyu8(formatTuukasyuBlank(kngkmisituukasyuLst.get(7)));
                syoumetuTuutiTy.setZtytekiyou9(tekiyouLst.get(8));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou9(meisaihugouLst.get(8).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai9(editGaikakngk(kngkmeisaiLst.get(8)));
                syoumetuTuutiTy.setZtyshrgktuukasyu9(formatTuukasyuBlank(kngkmisituukasyuLst.get(8)));
                syoumetuTuutiTy.setZtytekiyou10(tekiyouLst.get(9));
                syoumetuTuutiTy.setZtyshrkngkmeisaihugou10(meisaihugouLst.get(9).getValue());
                syoumetuTuutiTy.setZtyshrgkmeisai10(editGaikakngk(kngkmeisaiLst.get(9)));
                syoumetuTuutiTy.setZtyshrgktuukasyu10(formatTuukasyuBlank(kngkmisituukasyuLst.get(9)));
                syoumetuTuutiTy.setZtyshrgkgoukei(editGaikakngk(shrgkgoukei));
                syoumetuTuutiTy.setZtyshrtuukasyu(shrTuukasyu);
                syoumetuTuutiTy.setZtyshrnaiyouhskmongon1(shrNaiyouHskmongon1);
                syoumetuTuutiTy.setZtybanknmkj(banknmkj);
                syoumetuTuutiTy.setZtysitennmkj(sitennmkj);
                syoumetuTuutiTy.setZtyyokinkbn(yokinKbn.getValue());
                syoumetuTuutiTy.setZtykouzano12keta(kouzaNo);
                syoumetuTuutiTy.setZtykzmeiginmknhan(kzmeiginmkn);
                syoumetuTuutiTy.setZtykzsyurui(kouzasyuruiKbn.getValue());
                syoumetuTuutiTy.setZtysynykngk(synykngk);
                syoumetuTuutiTy.setZtysynykngktuukasyu(synykngkTuukasyu.getValue());
                syoumetuTuutiTy.setZtyhtykeihi(htykeihi);
                syoumetuTuutiTy.setZtyhtykeihituukasyu(htykeihiTuukasyu.getValue());
                syoumetuTuutiTy.setZtyshrkyksyahtykeihi(shrKyksyahtykeihi);
                syoumetuTuutiTy.setZtyshrkykhtykeihituukasyu(shrKyksyahtykeihiTuukasyu.getValue());
                syoumetuTuutiTy.setZtyzeimunaiyouhensyuctrlkbn(zeimuNaiyouHnsyuCtrlKbn.getValue());
                syoumetuTuutiTy.setZtyzeimumongonoutkbn(zeimumongonoutKbn.getValue());
                syoumetuTuutiTy.setZtyzeimumongon1(zeimumongon1);
                syoumetuTuutiTy.setZtyzeimumongon2(zeimumongon2);
                syoumetuTuutiTy.setZtyzeimumongon3(zeimumongon3);
                syoumetuTuutiTy.setZtyosirasehyoudai(sirasehyoudai);
                syoumetuTuutiTy.setZtyosirasemongon1(osirasemongonLst.get(0));
                syoumetuTuutiTy.setZtyosirasemongon2(osirasemongonLst.get(1));
                syoumetuTuutiTy.setZtyosirasemongon3(osirasemongonLst.get(2));
                syoumetuTuutiTy.setZtyosirasemongon4(osirasemongonLst.get(3));
                syoumetuTuutiTy.setZtyosirasemongon5(osirasemongonLst.get(4));
                syoumetuTuutiTy.setZtyosirasemongon6(osirasemongonLst.get(5));
                syoumetuTuutiTy.setZtyosirasemongon7(osirasemongonLst.get(6));
                syoumetuTuutiTy.setZtyosirasemongon8(osirasemongonLst.get(7));
                syoumetuTuutiTy.setZtyosirasemongon9(osirasemongonLst.get(8));
                syoumetuTuutiTy.setZtyosirasemongon10(osirasemongonLst.get(9));
                syoumetuTuutiTy.setZtyosirasemongon11(osirasemongonLst.get(10));
                syoumetuTuutiTy.setZtyosirasemongon12(osirasemongonLst.get(11));
                syoumetuTuutiTy.setZtyosirasemongon13(osirasemongonLst.get(12));
                syoumetuTuutiTy.setZtyosirasemongon14(osirasemongonLst.get(13));
                syoumetuTuutiTy.setZtyosirasemongon15(osirasemongonLst.get(14));
                syoumetuTuutiTy.setZtyosirasemongon16(osirasemongonLst.get(15));
                syoumetuTuutiTy.setZtyosirasemongon17(osirasemongonLst.get(16));
                syoumetuTuutiTy.setZtyosirasemongon18(osirasemongonLst.get(17));
                syoumetuTuutiTy.setZtyosirasemongon19(osirasemongonLst.get(18));
                syoumetuTuutiTy.setZtyosirasemongon20(osirasemongonLst.get(19));
                syoumetuTuutiTy.setZtyosirasemongon21(osirasemongonLst.get(20));
                syoumetuTuutiTy.setZtyosirasemongon22(osirasemongonLst.get(21));
                syoumetuTuutiTy.setZtyosirasemongon23(osirasemongonLst.get(22));
                syoumetuTuutiTy.setZtyosirasemongon24(osirasemongonLst.get(23));
                syoumetuTuutiTy.setZtyosirasemongon25(osirasemongonLst.get(24));
                syoumetuTuutiTy.setZtyosirasemongon26(osirasemongonLst.get(25));
                syoumetuTuutiTy.setZtyteisyutusrmongon1(teisyutusrmongon1);
                syoumetuTuutiTy.setZtyteisyutusrmongon2(teisyutusrmongon2);
                syoumetuTuutiTy.setZtyteisyutusrmongon3(teisyutusrmongon3);
                syoumetuTuutiTy.setZtyseikyuusyasyomeimongon1(seikyuusyasyomeimongon1);
                syoumetuTuutiTy.setZtyseikyuusyasyomeimongon2(seikyuusyasyomeimongon2);
                syoumetuTuutiTy.setZtyseikyuusyasyomeimongon3(seikyuusyasyomeimongon3);
                syoumetuTuutiTy.setZtyseikyuusyagenyno(seikyuusyagenyno);
                syoumetuTuutiTy.setZtyseikyuusyagenadr1(seikyuusyagenadr1);
                syoumetuTuutiTy.setZtyseikyuusyagenadr2(seikyuusyagenadr2);
                syoumetuTuutiTy.setZtyseikyuusyagenadr3(seikyuusyagenadr3);
                syoumetuTuutiTy.setZtyseikyuuyagentelno(seikyuuyagentelno);
                syoumetuTuutiTy.setZtyhozonkkny(hozonKikan);
                syoumetuTuutiTy.setZtyteisyutusrmongon4(teisyutusrmongon4);

                BizPropertyInitializer.initialize(syoumetuTuutiTy);
                syoumetuTuutiTyInserter.add(syoumetuTuutiTy);

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();

                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);

                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + khSyometuTuutiDataBean.getSyono());

                tuutirirekiMeisaiHokan.setTuutisakuseiymd(bzBatchParam.getSyoriYmd());

                tuutirirekiMeisaiHokan.setTuutisakuseino(0);

                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");

                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(bzBatchParam.getSyoriYmd());

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);

                tuutirirekiMeisaiHokanInserter.add(tuutirirekiMeisaiHokan);

                syoriKensuu = syoriKensuu + 1;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
    private String editGaikakngk(BizCurrency kngk) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        if(!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(kngk.getType()))){

            return kngk.multiply(100).toString();
        }
        else {
            return kngk.toString();
        }
    }

    private String formatTuukasyuBlank(C_Tuukasyu tuukasyu) {

        if (C_Tuukasyu.BLNK.eq(tuukasyu)) {
            return "";
        }
        else {
            return tuukasyu.getValue();
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
