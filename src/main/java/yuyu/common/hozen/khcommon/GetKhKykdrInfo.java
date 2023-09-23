package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TrkKzk;

/**
 * 契約保全 契約保全共通 契約者代理人情報取得
 */
public class GetKhKykdrInfo {

    @Inject
    private static Logger logger;

    public GetKhKykdrInfoBean exec(IT_KykKihon pKykkihon){

        logger.debug("▽ 契約者代理人情報取得 開始");
        GetKhKykdrInfoBean getKhKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);

        if (pKykkihon == null) {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS1003,"契約基本テーブル","null"));
        }

        List<IT_KykUkt> kykUktList = pKykkihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        if (kykUktList.size() == 0) {

            logger.debug("△ 契約者代理人情報取得 終了");
            return getKhKykdrInfoBean;
        }

        IT_TrkKzk trkKzk = null;
        IT_KykUkt kykUkt = kykUktList.get(0);
        if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {

            getKhKykdrInfoBean.setKkdairinmKn(kykUkt.getUktnmkn());
            getKhKykdrInfoBean.setKkdairinmKj(kykUkt.getUktnmkj());
            getKhKykdrInfoBean.setKkdairinmKjkhukaKbn(kykUkt.getUktnmkjkhukakbn());
            getKhKykdrInfoBean.setKykdryNo(kykUkt.getUktyno());
            getKhKykdrInfoBean.setKykdradr1(kykUkt.getUktadr1kj());
            getKhKykdrInfoBean.setKykdradr2(kykUkt.getUktadr2kj());
            getKhKykdrInfoBean.setKykdradr3(kykUkt.getUktadr3kj());
            getKhKykdrInfoBean.setKykdrtelno("");
            getKhKykdrInfoBean.setKykdrseiymd(kykUkt.getUktseiymd());
            getKhKykdrInfoBean.setKykdruktKbn(kykUkt.getUktkbn());

            logger.debug("△ 契約者代理人情報取得 終了");
            return getKhKykdrInfoBean;
        }
        else if (C_UktKbn.TOUROKUKAZOKU1.eq(kykUkt.getUktkbn())) {

            trkKzk = pKykkihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        }
        else if (C_UktKbn.TOUROKUKAZOKU2.eq(kykUkt.getUktkbn())) {

            trkKzk = pKykkihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        }

        if (trkKzk != null) {

            getKhKykdrInfoBean.setKkdairinmKn(trkKzk.getTrkkzknmkn());
            getKhKykdrInfoBean.setKkdairinmKj(trkKzk.getTrkkzknmkj());
            getKhKykdrInfoBean.setKkdairinmKjkhukaKbn(trkKzk.getTrkkzknmkjkhukakbn());
            getKhKykdrInfoBean.setKykdryNo(trkKzk.getTrkkzkyno());
            getKhKykdrInfoBean.setKykdradr1(trkKzk.getTrkkzkadr1kj());
            getKhKykdrInfoBean.setKykdradr2(trkKzk.getTrkkzkadr2kj());
            getKhKykdrInfoBean.setKykdradr3(trkKzk.getTrkkzkadr3kj());
            getKhKykdrInfoBean.setKykdrtelno(trkKzk.getTrkkzktelno());
            getKhKykdrInfoBean.setKykdrseiymd(trkKzk.getTrkkzkseiymd());
            getKhKykdrInfoBean.setKykdruktKbn(kykUkt.getUktkbn());

        }
        else {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,IT_TrkKzk.TABLE_NAME,
                IT_TrkKzk.SYONO,pKykkihon.getSyono()));
        }
        logger.debug("△ 契約者代理人情報取得 終了");

        return getKhKykdrInfoBean;
    }
}