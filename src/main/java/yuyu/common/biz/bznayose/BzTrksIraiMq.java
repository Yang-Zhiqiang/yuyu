package yuyu.common.biz.bznayose;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;

/**
 * 業務共通 名寄せ PALあて取消依頼（MQ）
 */
public class BzTrksIraiMq {

    @Inject
    private static Logger logger;

    public BzTrksIraiMq() {
        super();
    }

    public BzTrksIraiKekkaBean exec(BzTrksIraiYokenBean pBzTrksIraiYokenBean) {

        logger.debug("▽ PALあて取消依頼（MQ） 開始");

        BzTrksIraiKekkaBean bzTrksIraiKekkaBean = SWAKInjector.getInstance(BzTrksIraiKekkaBean.class);

        if (pBzTrksIraiYokenBean == null) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_SONOTA);
            bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.BLNK);

            logger.debug("△ PALあて取消依頼（MQ） 終了");
            return bzTrksIraiKekkaBean;
        }

        String youkyuunoLastData = pBzTrksIraiYokenBean.getYoukyuuno().substring(pBzTrksIraiYokenBean.getYoukyuuno().length() - 1);

        if ("6".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_SONOTA);

            if (C_KyknaiyouhaneiErrKbn.SYORIOK.eq(pBzTrksIraiYokenBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.ARI);
            }
            else if (C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU.eq(pBzTrksIraiYokenBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.KANOUSEIARI);
            }
        }
        else if ("7".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.HUMEI);
            bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.KANOUSEIARI);
        }
        else if ("5".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_SONOTA);

            if (C_KyknaiyouhaneiErrKbn.SYORIOK.eq(pBzTrksIraiYokenBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.ARI);
            }
            else if (C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU.eq(pBzTrksIraiYokenBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.KANOUSEIARI);
            }
        }
        else if ("4".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_TORIKESIZUMI);
            bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.NONE);
        }
        else if ("3".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_ATOSYORIARI);

            if (C_KyknaiyouhaneiErrKbn.SYORIOK.eq(pBzTrksIraiYokenBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.ARI);
            }
            else if (C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU.eq(pBzTrksIraiYokenBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.ARI);
            }
        }
        else if ("2".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_YOUKYUUNONONE);
            bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.NONE);
        }
        else if ("8".equals(youkyuunoLastData) || "0".equals(youkyuunoLastData)) {

            bzTrksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
            bzTrksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.TORIKESIOK);
            bzTrksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.NONE);
        }

        logger.debug("△ PALあて取消依頼（MQ） 終了");

        return bzTrksIraiKekkaBean;
    }
}
