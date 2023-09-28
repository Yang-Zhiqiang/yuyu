package yuyu.common.biz.bznayose;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNySk;

/**
 * 業務共通 名寄せ PALあて契約内容反映（MQ）
 */
public class BzKykNaiyouHaneiMq {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzKykNaiyouHaneiMq() {
        super();
    }

    public BzKykNaiyouHaneiKekkaBean exec(BzKykNaiyouHaneiYokenBean pBzKykNaiyouHaneiYokenBean) {

        logger.debug("▽ PALあて契約内容反映（MQ） 開始");

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean = SWAKInjector.getInstance(BzKykNaiyouHaneiKekkaBean.class);

        if (pBzKykNaiyouHaneiYokenBean == null) {
            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            logger.debug("△ PALあて契約内容反映（MQ） 終了");

            return bzKykNaiyouHaneiKekkaBean;
        }

        if (C_YouhiKbn.HUYOU.eq(pBzKykNaiyouHaneiYokenBean.getMqyouhikbn())) {

            tableNaiyouEdit(pBzKykNaiyouHaneiYokenBean, bzKykNaiyouHaneiKekkaBean, "");

            logger.debug("△ PALあて契約内容反映（MQ） 終了");

            return bzKykNaiyouHaneiKekkaBean;
        }

        BzYoukyuuNoKanriBean bzYoukyuuNoKanriBean = SWAKInjector.getInstance(BzYoukyuuNoKanriBean.class);
        BzYoukyuuNoKanri bzYoukyuuNoKanri = SWAKInjector.getInstance(BzYoukyuuNoKanri.class);

        bzYoukyuuNoKanriBean.setHuho2KykNoKbn(pBzKykNaiyouHaneiYokenBean.getHuho2kyknokbn());
        bzYoukyuuNoKanriBean.setHuho2KykNo(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());

        bzYoukyuuNoKanriBean = bzYoukyuuNoKanri.exec(bzYoukyuuNoKanriBean);
        String youkyuuNo = bzYoukyuuNoKanriBean.getYoukyuuNo();


        if ("0211".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            logger.debug("△ PALあて契約内容反映（MQ） 終了");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if ("0202".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0203".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0204".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0205".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0206".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0207".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0208".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));

            logger.debug("△ PALあて契約内容反映（MQ） 終了");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if ("0213".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            logger.debug("△ PALあて契約内容反映（MQ） 終了");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if ("0214".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0001");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            logger.debug("△ PALあて契約内容反映（MQ） 終了");

            return bzKykNaiyouHaneiKekkaBean;
        }
        else if ("0215".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo);
        }
        else if ("0216".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo);
        }
        else if ("0217".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo);
        }
        else if ("0102".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0103".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0104".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0105".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0106".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0107".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0108".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUNONE);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("4444444444");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0112".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0113".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0114".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0115".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0116".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0117".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0118".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("6666666666");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0122".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0123".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0124".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0125".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0126".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0127".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0128".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0302".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0303".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0304".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0305".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0306".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0307".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0308".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUNONE);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("3333333333");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0312".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0313".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0314".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0315".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0316".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0317".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0318".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("5555555555");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0322".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0323".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0324".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0325".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0326".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0327".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0328".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0502".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0503".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0504".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0505".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0506".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0507".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0508".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("2222222222");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("1111111111");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0512".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0513".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0514".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0515".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0516".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0517".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0518".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("2222222222");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("5555555555");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0522".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0523".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0524".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0525".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0526".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0527".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0528".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("6666666666");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("1111111111");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0602".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0603".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0604".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0605".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0606".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0607".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0608".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0702".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0703".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0704".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0705".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0706".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0707".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0708".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUNONE);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("1000033333");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0712".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0713".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0714".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0715".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0716".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0717".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0718".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("1000033333");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0722".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0723".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0724".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0725".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0726".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0727".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0728".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0902".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0903".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0904".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0905".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0906".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0907".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0908".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("2222222222");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("1000033333");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0912".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0913".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0914".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0915".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0916".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0917".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0918".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("2222222222");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("1000033333");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0922".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0923".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0924".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0925".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0926".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0927".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0928".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("6666666666");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("1000033333");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else if ("0932".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0933".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0934".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0935".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0936".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0937".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))
            || "0938".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 4))) {

            bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

            bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

            bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

            bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

            bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

            bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

            bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo.substring(0, 17) + pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(3, 4));
        }
        else {

            if ("01".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 2))
                || "03".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 2))
                || "05".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 2))
                || "07".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 2))
                || "09".equals(pBzKykNaiyouHaneiYokenBean.getTsintelno().substring(0, 2))) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

                bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

                bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("2222222222");

                bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("1111111111");

                bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

                bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("1000033333");

                bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo);
            }

            else {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);

                bzKykNaiyouHaneiKekkaBean.setAcserrcd("0000");

                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

                bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("");

                bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("");

                bzKykNaiyouHaneiKekkaBean.setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);

                bzKykNaiyouHaneiKekkaBean.setNkuktsakuinnmno("");

                bzKykNaiyouHaneiKekkaBean.setYoukyuuno(youkyuuNo);
            }
        }

        if (C_KyknaiyouhaneiErrKbn.SYORIOK.eq(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn())) {

            tableNaiyouEdit(pBzKykNaiyouHaneiYokenBean, bzKykNaiyouHaneiKekkaBean, youkyuuNo);
        }

        logger.debug("△ PALあて契約内容反映（MQ） 終了");

        return bzKykNaiyouHaneiKekkaBean;
    }

    private void tableNaiyouEdit(BzKykNaiyouHaneiYokenBean pBzKykNaiyouHaneiYokenBean,
        BzKykNaiyouHaneiKekkaBean pBzKykNaiyouHaneiKekkaBean, String pYoukyuuNo) {

        Integer maxRenno3keta = 0;

        if (C_Huho2kyknoKbn.SYONO.eq(pBzKykNaiyouHaneiYokenBean.getHuho2kyknokbn())) {


            maxRenno3keta =
                bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());

            if (maxRenno3keta != null) {
                maxRenno3keta++;
            }
            else {
                maxRenno3keta = 1;
            }

            BT_TjtIdouNyKh tjtIdouNyKh = new BT_TjtIdouNyKh();

            tjtIdouNyKh.setSyono(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            tjtIdouNyKh.setRenno3keta(maxRenno3keta);
            tjtIdouNyKh.setRecordsakujyohyouji(pBzKykNaiyouHaneiYokenBean.getRecordsakujyohyouji());

            if (C_YouhiKbn.HUYOU.eq(pBzKykNaiyouHaneiYokenBean.getMqyouhikbn())) {

                tjtIdouNyKh.setYoukyuuno("");
            }
            else {

                tjtIdouNyKh.setYoukyuuno(pYoukyuuNo);
            }

            tjtIdouNyKh.setSyouhncd(pBzKykNaiyouHaneiYokenBean.getKhsyouhncd());
            tjtIdouNyKh.setKykjyoutai(pBzKykNaiyouHaneiYokenBean.getKhkykjyoutai());
            tjtIdouNyKh.setKykymd(pBzKykNaiyouHaneiYokenBean.getKhkykymd());
            tjtIdouNyKh.setYuukousyoumetukbn(pBzKykNaiyouHaneiYokenBean.getKhyuukousyoumetukbn());
            tjtIdouNyKh.setSyoumetujiyuu(pBzKykNaiyouHaneiYokenBean.getKhsyoumetujiyuu());
            tjtIdouNyKh.setSyoumetuymd(pBzKykNaiyouHaneiYokenBean.getKhsyoumetuymd());
            tjtIdouNyKh.setKyktuukasyu(pBzKykNaiyouHaneiYokenBean.getKhkyktuukasyu());
            tjtIdouNyKh.setTsnyousibous(pBzKykNaiyouHaneiYokenBean.getKhtsnsibous());
            tjtIdouNyKh.setTsnyouitijip(pBzKykNaiyouHaneiYokenBean.getKhtsnitijip());
            tjtIdouNyKh.setTsnyounkgns(pBzKykNaiyouHaneiYokenBean.getKhtsnnkgns());
            tjtIdouNyKh.setHrkkkn(pBzKykNaiyouHaneiYokenBean.getKhhrkkkn());
            tjtIdouNyKh.setSntkhoukbn(pBzKykNaiyouHaneiYokenBean.getKhsntkhoukbn());
            tjtIdouNyKh.setBosyuuym(pBzKykNaiyouHaneiYokenBean.getKhbosyuuym());
            tjtIdouNyKh.setKykhhkndouhyouji(pBzKykNaiyouHaneiYokenBean.getKhkykhhkndouhyouji());
            tjtIdouNyKh.setTtdktyuuikbn1(pBzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn1());
            tjtIdouNyKh.setTtdktyuuikbn2(pBzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn2());
            tjtIdouNyKh.setTtdktyuuikbn3(pBzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn3());
            tjtIdouNyKh.setTtdktyuuikbn4(pBzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn4());
            tjtIdouNyKh.setTtdktyuuikbn5(pBzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn5());
            tjtIdouNyKh.setSyouhnsdno(pBzKykNaiyouHaneiYokenBean.getKhsyouhnsdno());
            tjtIdouNyKh.setKaigomaehrtkykumukbn(pBzKykNaiyouHaneiYokenBean.getKhkaigomaehrtkykumukbn());
            tjtIdouNyKh.setPyennykntkykumukbn(pBzKykNaiyouHaneiYokenBean.getKhpyennykntkykumukbn());
            tjtIdouNyKh.setTsnyennyknkgk(pBzKykNaiyouHaneiYokenBean.getKhtsnyennyknkgk());
            tjtIdouNyKh.setSkjmosno(pBzKykNaiyouHaneiYokenBean.getKhskjmosno());
            tjtIdouNyKh.setGyoumuKousinKinou(kinou.getKinouId());
            tjtIdouNyKh.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            tjtIdouNyKh.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(tjtIdouNyKh);


            BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.createIdouKhMeigi();

            idouKhMeigi.setSyono(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            idouKhMeigi.setRenno3keta(maxRenno3keta);
            idouKhMeigi.setHhknnmkn(pBzKykNaiyouHaneiYokenBean.getHhknnmkn());
            idouKhMeigi.setHhknnmkj(pBzKykNaiyouHaneiYokenBean.getHhknnmkj());
            idouKhMeigi.setHhknseiymd(pBzKykNaiyouHaneiYokenBean.getHhknseiymd());
            idouKhMeigi.setHhknsei(pBzKykNaiyouHaneiYokenBean.getHhknsei());
            idouKhMeigi.setHhknyno(pBzKykNaiyouHaneiYokenBean.getHhknyno());
            idouKhMeigi.setHhknadr1kj(pBzKykNaiyouHaneiYokenBean.getHhknadr1kj());
            idouKhMeigi.setHhknadr2kj(pBzKykNaiyouHaneiYokenBean.getHhknadr2kj());
            idouKhMeigi.setHhknadr3kj(pBzKykNaiyouHaneiYokenBean.getHhknadr3kj());
            idouKhMeigi.setHhkntelno(pBzKykNaiyouHaneiYokenBean.getHhkntelno());
            idouKhMeigi.setHhknsykgycd(pBzKykNaiyouHaneiYokenBean.getHhknsykgycd());
            idouKhMeigi.setKyknmkn(pBzKykNaiyouHaneiYokenBean.getKyknmkn());
            idouKhMeigi.setKyknmkj(pBzKykNaiyouHaneiYokenBean.getKyknmkj());
            idouKhMeigi.setKykseiymd(pBzKykNaiyouHaneiYokenBean.getKykseiymd());
            idouKhMeigi.setNenkinuktnmkana(pBzKykNaiyouHaneiYokenBean.getNenkinuktnmkana());
            idouKhMeigi.setNenkinuktnmkanji(pBzKykNaiyouHaneiYokenBean.getNenkinuktnmkanji());
            idouKhMeigi.setNenkinuktseiymd(pBzKykNaiyouHaneiYokenBean.getNenkinuktseiymd());
            idouKhMeigi.setTsinyno(pBzKykNaiyouHaneiYokenBean.getTsinyno());
            idouKhMeigi.setTsinadr1kj(pBzKykNaiyouHaneiYokenBean.getTsinadr1kj());
            idouKhMeigi.setTsinadr2kj(pBzKykNaiyouHaneiYokenBean.getTsinadr2kj());
            idouKhMeigi.setTsinadr3kj(pBzKykNaiyouHaneiYokenBean.getTsinadr3kj());
            idouKhMeigi.setTsintelno(pBzKykNaiyouHaneiYokenBean.getTsintelno());
            idouKhMeigi.setSbuktnmkn1(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn1());
            idouKhMeigi.setSbuktnmkj1(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj1());
            idouKhMeigi.setSbuktnmkn2(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn2());
            idouKhMeigi.setSbuktnmkj2(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj2());
            idouKhMeigi.setSbuktnmkn3(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn3());
            idouKhMeigi.setSbuktnmkj3(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj3());
            idouKhMeigi.setSbuktnmkn4(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn4());
            idouKhMeigi.setSbuktnmkj4(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj4());
            idouKhMeigi.setStdrsknmkn(pBzKykNaiyouHaneiYokenBean.getStdrsknmkn());
            idouKhMeigi.setStdrsknmkj(pBzKykNaiyouHaneiYokenBean.getStdrsknmkj());

            BizPropertyInitializer.initialize(idouKhMeigi);


            BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.createIdouKhBosyuudr();

            idouKhBosyuudr.setSyono(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            idouKhBosyuudr.setRenno3keta(maxRenno3keta);
            idouKhBosyuudr.setDairitencd1(pBzKykNaiyouHaneiYokenBean.getDairitencd1());
            idouKhBosyuudr.setBunwari1(pBzKykNaiyouHaneiYokenBean.getBunwari1());
            idouKhBosyuudr.setDairitencd2(pBzKykNaiyouHaneiYokenBean.getDairitencd2());
            idouKhBosyuudr.setBunwari2(pBzKykNaiyouHaneiYokenBean.getBunwari2());
            idouKhBosyuudr.setKanrisosikicd1(pBzKykNaiyouHaneiYokenBean.getKanrisosikicd1());
            idouKhBosyuudr.setKanrisosikicd2(pBzKykNaiyouHaneiYokenBean.getKanrisosikicd2());

            BizPropertyInitializer.initialize(idouKhBosyuudr);

            pBzKykNaiyouHaneiKekkaBean.setTjtidounykh(tjtIdouNyKh);

        }
        else if (C_Huho2kyknoKbn.MOSNO.eq(pBzKykNaiyouHaneiYokenBean.getHuho2kyknokbn())) {

            maxRenno3keta =
                bizDomManager.getTjtIdouNySkMaxRenno3ketaByMosno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());

            if (maxRenno3keta != null) {
                maxRenno3keta++;
            }
            else {
                maxRenno3keta = 1;
            }

            BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();

            tjtIdouNySk.setMosno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            tjtIdouNySk.setRenno3keta(maxRenno3keta);
            tjtIdouNySk.setRecordsakujyohyouji(pBzKykNaiyouHaneiYokenBean.getRecordsakujyohyouji());

            if (C_YouhiKbn.HUYOU.eq(pBzKykNaiyouHaneiYokenBean.getMqyouhikbn())) {

                tjtIdouNySk.setYoukyuuno("");
            }
            else {

                tjtIdouNySk.setYoukyuuno(pYoukyuuNo);
            }

            tjtIdouNySk.setSyouhncd(pBzKykNaiyouHaneiYokenBean.getSksyouhncd());
            tjtIdouNySk.setMosymd(pBzKykNaiyouHaneiYokenBean.getSkmosymd());
            tjtIdouNySk.setKykymd(pBzKykNaiyouHaneiYokenBean.getSkkykymd());
            tjtIdouNySk.setSknnkaisiymd(pBzKykNaiyouHaneiYokenBean.getSksknnkaisiymd());
            tjtIdouNySk.setSeiritukbn(pBzKykNaiyouHaneiYokenBean.getSkseiritukbn());
            tjtIdouNySk.setSrsyoriymd(pBzKykNaiyouHaneiYokenBean.getSksrsyoriymd());
            tjtIdouNySk.setMfrenflg(pBzKykNaiyouHaneiYokenBean.getSkmfrenflg());
            tjtIdouNySk.setSyono(pBzKykNaiyouHaneiYokenBean.getSksyono());
            tjtIdouNySk.setKyktuukasyu(pBzKykNaiyouHaneiYokenBean.getSkkyktuukasyu());
            tjtIdouNySk.setTsnyousibous(pBzKykNaiyouHaneiYokenBean.getSktsnsibous());
            tjtIdouNySk.setTsnyouitijip(pBzKykNaiyouHaneiYokenBean.getSktsnitijip());
            tjtIdouNySk.setTsnyounkgns(pBzKykNaiyouHaneiYokenBean.getSktsnnkgns());
            tjtIdouNySk.setHrkkkn(pBzKykNaiyouHaneiYokenBean.getSkhrkkkn());
            tjtIdouNySk.setSntkhoukbn(pBzKykNaiyouHaneiYokenBean.getSksntkhoukbn());
            tjtIdouNySk.setBosyuuym(pBzKykNaiyouHaneiYokenBean.getSkbosyuuym());
            tjtIdouNySk.setKykhhkndouhyouji(pBzKykNaiyouHaneiYokenBean.getSkkykhhkndouhyouji());
            tjtIdouNySk.setMossyoumetukbn(pBzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn());
            tjtIdouNySk.setSyouhnsdno(pBzKykNaiyouHaneiYokenBean.getSksyouhnsdno());
            tjtIdouNySk.setKaigomaehrtkykumukbn(pBzKykNaiyouHaneiYokenBean.getSkkaigomaehrtkykumukbn());
            tjtIdouNySk.setPyennykntkykumukbn(pBzKykNaiyouHaneiYokenBean.getSkpyennykntkykumukbn());
            tjtIdouNySk.setTsnyennyknkgk(pBzKykNaiyouHaneiYokenBean.getSktsnyennyknkgk());
            tjtIdouNySk.setGyoumuKousinKinou(kinou.getKinouId());
            tjtIdouNySk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            tjtIdouNySk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(tjtIdouNySk);

            BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.createIdouSkMeigi();

            idouSkMeigi.setMosno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            idouSkMeigi.setRenno3keta(maxRenno3keta);
            idouSkMeigi.setHhknnmkn(pBzKykNaiyouHaneiYokenBean.getHhknnmkn());
            idouSkMeigi.setHhknnmkj(pBzKykNaiyouHaneiYokenBean.getHhknnmkj());
            idouSkMeigi.setHhknseiymd(pBzKykNaiyouHaneiYokenBean.getHhknseiymd());
            idouSkMeigi.setHhknsei(pBzKykNaiyouHaneiYokenBean.getHhknsei());
            idouSkMeigi.setHhknyno(pBzKykNaiyouHaneiYokenBean.getHhknyno());
            idouSkMeigi.setHhknadr1kj(pBzKykNaiyouHaneiYokenBean.getHhknadr1kj());
            idouSkMeigi.setHhknadr2kj(pBzKykNaiyouHaneiYokenBean.getHhknadr2kj());
            idouSkMeigi.setHhknadr3kj(pBzKykNaiyouHaneiYokenBean.getHhknadr3kj());
            idouSkMeigi.setHhkntelno(pBzKykNaiyouHaneiYokenBean.getHhkntelno());
            idouSkMeigi.setHhknsykgycd(pBzKykNaiyouHaneiYokenBean.getHhknsykgycd());
            idouSkMeigi.setKyknmkn(pBzKykNaiyouHaneiYokenBean.getKyknmkn());
            idouSkMeigi.setKyknmkj(pBzKykNaiyouHaneiYokenBean.getKyknmkj());
            idouSkMeigi.setKykseiymd(pBzKykNaiyouHaneiYokenBean.getKykseiymd());
            idouSkMeigi.setNenkinuktnmkana(pBzKykNaiyouHaneiYokenBean.getNenkinuktnmkana());
            idouSkMeigi.setNenkinuktnmkanji(pBzKykNaiyouHaneiYokenBean.getNenkinuktnmkanji());
            idouSkMeigi.setNenkinuktseiymd(pBzKykNaiyouHaneiYokenBean.getNenkinuktseiymd());
            idouSkMeigi.setTsinyno(pBzKykNaiyouHaneiYokenBean.getTsinyno());
            idouSkMeigi.setTsinadr1kj(pBzKykNaiyouHaneiYokenBean.getTsinadr1kj());
            idouSkMeigi.setTsinadr2kj(pBzKykNaiyouHaneiYokenBean.getTsinadr2kj());
            idouSkMeigi.setTsinadr3kj(pBzKykNaiyouHaneiYokenBean.getTsinadr3kj());
            idouSkMeigi.setTsintelno(pBzKykNaiyouHaneiYokenBean.getTsintelno());
            idouSkMeigi.setSbuktnmkn1(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn1());
            idouSkMeigi.setSbuktnmkj1(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj1());
            idouSkMeigi.setSbuktnmkn2(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn2());
            idouSkMeigi.setSbuktnmkj2(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj2());
            idouSkMeigi.setSbuktnmkn3(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn3());
            idouSkMeigi.setSbuktnmkj3(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj3());
            idouSkMeigi.setSbuktnmkn4(pBzKykNaiyouHaneiYokenBean.getSbuktnmkn4());
            idouSkMeigi.setSbuktnmkj4(pBzKykNaiyouHaneiYokenBean.getSbuktnmkj4());
            idouSkMeigi.setStdrsknmkn(pBzKykNaiyouHaneiYokenBean.getStdrsknmkn());
            idouSkMeigi.setStdrsknmkj(pBzKykNaiyouHaneiYokenBean.getStdrsknmkj());

            BizPropertyInitializer.initialize(idouSkMeigi);


            BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.createIdouSkBosyuudr();

            idouSkBosyuudr.setMosno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            idouSkBosyuudr.setRenno3keta(maxRenno3keta);
            idouSkBosyuudr.setDairitencd1(pBzKykNaiyouHaneiYokenBean.getDairitencd1());
            idouSkBosyuudr.setBunwari1(pBzKykNaiyouHaneiYokenBean.getBunwari1());
            idouSkBosyuudr.setDairitencd2(pBzKykNaiyouHaneiYokenBean.getDairitencd2());
            idouSkBosyuudr.setBunwari2(pBzKykNaiyouHaneiYokenBean.getBunwari2());
            idouSkBosyuudr.setKanrisosikicd1(pBzKykNaiyouHaneiYokenBean.getKanrisosikicd1());
            idouSkBosyuudr.setKanrisosikicd2(pBzKykNaiyouHaneiYokenBean.getKanrisosikicd2());

            BizPropertyInitializer.initialize(idouSkBosyuudr);

            pBzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

        }
        else if (C_Huho2kyknoKbn.NKSYSYNO.eq(pBzKykNaiyouHaneiYokenBean.getHuho2kyknokbn())) {

            maxRenno3keta =
                bizDomManager.getTjtIdouNyNkMaxRenno3ketaByNksysyno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());

            if (maxRenno3keta != null) {
                maxRenno3keta++;
            }
            else {
                maxRenno3keta = 1;
            }

            BT_TjtIdouNyNk tjtIdouNyNk = new BT_TjtIdouNyNk();

            tjtIdouNyNk.setNksysyno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            tjtIdouNyNk.setRenno3keta(maxRenno3keta);
            tjtIdouNyNk.setRecordsakujyohyouji(pBzKykNaiyouHaneiYokenBean.getRecordsakujyohyouji());

            if (C_YouhiKbn.HUYOU.eq(pBzKykNaiyouHaneiYokenBean.getMqyouhikbn())) {

                tjtIdouNyNk.setYoukyuuno("");
            }
            else {

                tjtIdouNyNk.setYoukyuuno(pYoukyuuNo);
            }

            tjtIdouNyNk.setSyouhncd(pBzKykNaiyouHaneiYokenBean.getNksyouhncd());
            tjtIdouNyNk.setNkshrstartymd(pBzKykNaiyouHaneiYokenBean.getNknkshrstartymd());
            tjtIdouNyNk.setKykymd(pBzKykNaiyouHaneiYokenBean.getNkkykymd());
            tjtIdouNyNk.setNksyoumetucd(pBzKykNaiyouHaneiYokenBean.getNknksyoumetucd());
            tjtIdouNyNk.setSyoumetuymd(pBzKykNaiyouHaneiYokenBean.getNksyoumetuymd());
            tjtIdouNyNk.setShrtuukasyu(pBzKykNaiyouHaneiYokenBean.getNkshrtuukasyu());
            tjtIdouNyNk.setTeinksyu(pBzKykNaiyouHaneiYokenBean.getNkteinksyu());
            tjtIdouNyNk.setTsnyounkgns(pBzKykNaiyouHaneiYokenBean.getNktsnnkgns());
            tjtIdouNyNk.setNkukthhkndouhyouji(pBzKykNaiyouHaneiYokenBean.getNknkukthhkndouhyouji());
            tjtIdouNyNk.setSyouhnsdno(pBzKykNaiyouHaneiYokenBean.getNksyouhnsdno());
            tjtIdouNyNk.setGyoumuKousinKinou(kinou.getKinouId());
            tjtIdouNyNk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            tjtIdouNyNk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(tjtIdouNyNk);

            BT_IdouNkMeigi idouNkMeigi = tjtIdouNyNk.createIdouNkMeigi();

            idouNkMeigi.setNksysyno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            idouNkMeigi.setRenno3keta(maxRenno3keta);
            idouNkMeigi.setHhknnmkn(pBzKykNaiyouHaneiYokenBean.getHhknnmkn());
            idouNkMeigi.setHhknnmkj(pBzKykNaiyouHaneiYokenBean.getHhknnmkj());
            idouNkMeigi.setHhknseiymd(pBzKykNaiyouHaneiYokenBean.getHhknseiymd());
            idouNkMeigi.setHhknsei(pBzKykNaiyouHaneiYokenBean.getHhknsei());
            idouNkMeigi.setHhknyno(pBzKykNaiyouHaneiYokenBean.getHhknyno());
            idouNkMeigi.setHhknadr1kj(pBzKykNaiyouHaneiYokenBean.getHhknadr1kj());
            idouNkMeigi.setHhknadr2kj(pBzKykNaiyouHaneiYokenBean.getHhknadr2kj());
            idouNkMeigi.setHhknadr3kj(pBzKykNaiyouHaneiYokenBean.getHhknadr3kj());
            idouNkMeigi.setHhkntelno(pBzKykNaiyouHaneiYokenBean.getHhkntelno());
            idouNkMeigi.setHhknsykgycd(pBzKykNaiyouHaneiYokenBean.getHhknsykgycd());
            idouNkMeigi.setNenkinuktnmkana(pBzKykNaiyouHaneiYokenBean.getNenkinuktnmkana());
            idouNkMeigi.setNenkinuktnmkanji(pBzKykNaiyouHaneiYokenBean.getNenkinuktnmkanji());
            idouNkMeigi.setNenkinuktseiymd(pBzKykNaiyouHaneiYokenBean.getNenkinuktseiymd());
            idouNkMeigi.setTsinyno(pBzKykNaiyouHaneiYokenBean.getTsinyno());
            idouNkMeigi.setTsinadr1kj(pBzKykNaiyouHaneiYokenBean.getTsinadr1kj());
            idouNkMeigi.setTsinadr2kj(pBzKykNaiyouHaneiYokenBean.getTsinadr2kj());
            idouNkMeigi.setTsinadr3kj(pBzKykNaiyouHaneiYokenBean.getTsinadr3kj());
            idouNkMeigi.setTsintelno(pBzKykNaiyouHaneiYokenBean.getTsintelno());

            BizPropertyInitializer.initialize(idouNkMeigi);


            BT_IdouNkBosyuudr idouNkBosyuudr = tjtIdouNyNk.createIdouNkBosyuudr();

            idouNkBosyuudr.setNksysyno(pBzKykNaiyouHaneiYokenBean.getHuho2kykno());
            idouNkBosyuudr.setRenno3keta(maxRenno3keta);
            idouNkBosyuudr.setDairitencd1(pBzKykNaiyouHaneiYokenBean.getDairitencd1());
            idouNkBosyuudr.setBunwari1(pBzKykNaiyouHaneiYokenBean.getBunwari1());
            idouNkBosyuudr.setDairitencd2(pBzKykNaiyouHaneiYokenBean.getDairitencd2());
            idouNkBosyuudr.setBunwari2(pBzKykNaiyouHaneiYokenBean.getBunwari2());
            idouNkBosyuudr.setKanrisosikicd1(pBzKykNaiyouHaneiYokenBean.getKanrisosikicd1());
            idouNkBosyuudr.setKanrisosikicd2(pBzKykNaiyouHaneiYokenBean.getKanrisosikicd2());

            BizPropertyInitializer.initialize(idouNkBosyuudr);

            pBzKykNaiyouHaneiKekkaBean.setTjtidounynk(tjtIdouNyNk);
        }
    }
}
