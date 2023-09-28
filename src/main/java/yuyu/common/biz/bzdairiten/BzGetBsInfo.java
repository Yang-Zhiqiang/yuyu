package yuyu.common.biz.bzdairiten;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.detacher.BM_BosyuuninDetacher;
import yuyu.def.biz.detacher.BM_KouinDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.entity.BM_Kouin;

/**
 * 業務共通 代理店 募集人情報取得（募集人コード指定）クラス
 */
public class BzGetBsInfo {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetBsInfo() {
        super();
    }

    public BzGetBsInfoBean exec(String pBosyuuCd) {

        logger.debug("▽ 募集人情報取得（募集人コード指定） 開始");
        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 募集人コード＝" + pBosyuuCd);
        logger.debug("｜ △ ");

        if (BizUtil.isBlank(pBosyuuCd)) {

            logger.debug("△ 募集人情報取得（募集人コード指定） 終了");

            return null;
        }

        BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin(pBosyuuCd);

        if (bosyuunin == null) {

            logger.debug("｜ 指定した募集人コードの募集人情報が存在しません。");
            logger.debug("△ 募集人情報取得（募集人コード指定） 終了");

            return null;
        }

        bosyuunin = BM_BosyuuninDetacher.detachBosyuunintouched(bosyuunin);

        BzGetBsInfoBean bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfoBean.class);

        bzGetBsInfo.setBosyuuCd(bosyuunin.getBosyuucd());

        bzGetBsInfo.setBosyuuNm(bosyuunin.getBosyuunm());

        bzGetBsInfo.setKanjiBosyuuninNm(bosyuunin.getKanjibosyuuninnm());

        bzGetBsInfo.setItakuYmd(bosyuunin.getItakuymd());

        bzGetBsInfo.setDairiten1Cd(bosyuunin.getDairiten1cd());

        bzGetBsInfo.setDairiten2Cd(bosyuunin.getDairiten2cd());

        bzGetBsInfo.setDairiten3Cd(bosyuunin.getDairiten3cd());

        bzGetBsInfo.setDairitenKanriSosikiCd1(bosyuunin.getDairitenkanrisosikicd1());

        bzGetBsInfo.setDairitenKanriSosikiCd2(bosyuunin.getDairitenkanrisosikicd2());

        bzGetBsInfo.setDairitenKanriSosikiCd3(bosyuunin.getDairitenkanrisosikicd3());

        bzGetBsInfo.setBosyuuKbn(bosyuunin.getBosyuukbn());

        bzGetBsInfo.setBosyuuninTourokuYmd(bosyuunin.getBosyuunintourokuymd());

        bzGetBsInfo.setBosyuuKahiKbn(bosyuunin.getBosyuukahikbn());

        bzGetBsInfo.setBosyuuninGyouhaiYmd(bosyuunin.getBosyuuningyouhaiymd());

        bzGetBsInfo.setHngkHknSkkTrkYmd(bosyuunin.getHngkhknskktrkymd());

        bzGetBsInfo.setHngkHknSkkTrkMsuYmd(bosyuunin.getHngkhknskktrkmsuymd());

        bzGetBsInfo.setBosyuuSeiYmd(bosyuunin.getBosyuuseiymd());

        bzGetBsInfo.setItakuKaiyakuYmd(bosyuunin.getItakukaiyakuymd());

        bzGetBsInfo.setDaiBosyuuCd(bosyuunin.getDaibosyuucd());

        bzGetBsInfo.setBosyuuTrkNo(bosyuunin.getBosyuutrkno());

        List<BM_Kouin> kouinList = bizDomManager.getKouinsBybosyuucd(pBosyuuCd);

        if (kouinList.size() == 0) {

            bzGetBsInfo.setKouinCd("");
        }
        else {

            BM_Kouin kouin = BM_KouinDetacher.detachKouintouched(kouinList.get(0));

            bzGetBsInfo.setKouinCd(kouin.getKouincd());
        }

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ 募集人コード＝" + bzGetBsInfo.getBosyuuCd());
        logger.debug("｜ △ ");
        logger.debug("△ 募集人情報取得（募集人コード指定） 終了");

        return bzGetBsInfo;
    }
}
