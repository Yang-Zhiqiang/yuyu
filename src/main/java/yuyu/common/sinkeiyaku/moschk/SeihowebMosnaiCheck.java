package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_KouzokujkKbn;

/**
 * 新契約 申込内容チェック 生保Ｗｅｂ申込内容チェック
 */
public class SeihowebMosnaiCheck {

    @Inject
    private static Logger logger;

    public SeihowebMosnaiCheck() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        logger.debug("▽ 生保Ｗｅｂ申込内容チェック 開始");

        JidouSetSyokika jidouSetSyokika = SWAKInjector.getInstance(JidouSetSyokika.class);
        jidouSetSyokika.exec(pMP);

        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);
        setKisoKoumoku.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckTblMosDairiten checkTblMosDairiten = SWAKInjector.getInstance(CheckTblMosDairiten.class);
        checkTblMosDairiten.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        nayose.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);
        checkTblMosKihon.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        checkTblMosSyouhin.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckSentakujyouhou checkSentakujyouhou = SWAKInjector.getInstance(CheckSentakujyouhou.class);
        checkSentakujyouhou.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        SetSP setSP = SWAKInjector.getInstance(SetSP.class);
        setSP.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckSkTuusan checkSkTuusan =  SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        CheckNyuukin checkNyuukin =  SWAKInjector.getInstance(CheckNyuukin.class);
        checkNyuukin.exec(pMP);

        if (C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            outputEndLog();
            return;
        }

        outputEndLog();
    }

    private void outputEndLog() {

        logger.debug("△ 生保Ｗｅｂ申込内容チェック 終了");
    }
}
