package yuyu.common.biz.bznayose;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_MqkousintrksiraiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;

/**
 * 業務共通 名寄せ 要求通番管理テーブル追加更新
 */
public class BzYoukyuuNoKanriTblTuikaKousin {

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    public BzYoukyuuNoKanriTblTuikaKousin() {
        super();
    }

    @Transactional
    public void exec(BzYoukyuuNoKanriTblTuikaKousinBean pBzYoukyuuNoKanriTblTuikaKousinBean) {

        logger.debug("▽ 要求通番管理テーブル追加更新 開始");

        BT_YoukyuuNoKanri youkyuuNoKanri = new BT_YoukyuuNoKanri();

        if (C_MqkousintrksiraiKbn.MQ_KOUSIN.eq(pBzYoukyuuNoKanriTblTuikaKousinBean.getMqkousintrksiraiKbn())) {

            youkyuuNoKanri.setYoukyuuno(pBzYoukyuuNoKanriTblTuikaKousinBean.getYoukyuuNo());
            youkyuuNoKanri.setHuho2kyknokbn(pBzYoukyuuNoKanriTblTuikaKousinBean.getHuho2KykNoKbn());
            youkyuuNoKanri.setHuho2kykno(pBzYoukyuuNoKanriTblTuikaKousinBean.getHuho2KykNo());
            youkyuuNoKanri.setMqkousinmqsyorikekkakbn(pBzYoukyuuNoKanriTblTuikaKousinBean.getMqSyorikekkaKbn());
            youkyuuNoKanri.setMqkousinacserrcd(pBzYoukyuuNoKanriTblTuikaKousinBean.getAcserrcd());
            youkyuuNoKanri.setKyknaiyouhaneierrkbn(pBzYoukyuuNoKanriTblTuikaKousinBean.getKyknaiyouhaneiErrKbn());
            youkyuuNoKanri.setGyoumuKousinKinou(kinou.getKinouId());
            youkyuuNoKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            youkyuuNoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(youkyuuNoKanri);

            ExDBTransactionalUtil.insert(youkyuuNoKanri);
        }
        else if (C_MqkousintrksiraiKbn.MQ_TRKSIRAI.eq(pBzYoukyuuNoKanriTblTuikaKousinBean.getMqkousintrksiraiKbn())) {

            youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(pBzYoukyuuNoKanriTblTuikaKousinBean.getYoukyuuNo());

            youkyuuNoKanri.setMqtrksiraimqsyorikekkakbn(pBzYoukyuuNoKanriTblTuikaKousinBean.getMqSyorikekkaKbn());
            youkyuuNoKanri.setMqtrksiraiacserrcd(pBzYoukyuuNoKanriTblTuikaKousinBean.getAcserrcd());
            youkyuuNoKanri.setTrkskekkakbn(pBzYoukyuuNoKanriTblTuikaKousinBean.getTorikesiKekkaKbn());
            youkyuuNoKanri.setJdtrkspaltrkszankbn(pBzYoukyuuNoKanriTblTuikaKousinBean.getJdTrksPalTrksZanKbn());
            youkyuuNoKanri.setGyoumuKousinKinou(kinou.getKinouId());
            youkyuuNoKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            youkyuuNoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.update(youkyuuNoKanri);
        }

        logger.debug("△ 要求通番管理テーブル追加更新 終了");

    }
}
