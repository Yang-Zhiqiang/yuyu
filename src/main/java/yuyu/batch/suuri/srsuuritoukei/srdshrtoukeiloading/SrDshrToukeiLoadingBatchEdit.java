package yuyu.batch.suuri.srsuuritoukei.srdshrtoukeiloading;

import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;

/**
 * 数理 数理統計 Ｄ支払統計ローディング情報作成パラメータクラス
 */
public class SrDshrToukeiLoadingBatchEdit {

    private boolean errorFlg;

    public SrDshrToukeiLoadingBatchEdit() {

        errorFlg = false;
    }

    public boolean editKoumoku(SrDshrToukeiLoadingBatchParam pSrDshrToukeiLoadingBatchParam,
        StDshrTukiTyukeiyouItzHznBean pStDshrTukiTyukeiyouItzHznBeanBean, ZT_DshrToukeiLoadingTy pDshrToukeiLoadingTy) {

        editHeaderKoumoku(pSrDshrToukeiLoadingBatchParam, pDshrToukeiLoadingTy);

        editDshrToukeiLoadingKoumoku(pStDshrTukiTyukeiyouItzHznBeanBean, pDshrToukeiLoadingTy);

        return errorFlg;
    }

    private void editHeaderKoumoku(SrDshrToukeiLoadingBatchParam pSrDshrToukeiLoadingBatchParam,
        ZT_DshrToukeiLoadingTy pDshrToukeiLoadingTy) {

        Integer keyKoumoku = pSrDshrToukeiLoadingBatchParam.getSyoriKensuu();

        pSrDshrToukeiLoadingBatchParam.setSyoriKensuu(pSrDshrToukeiLoadingBatchParam.getSyoriKensuu() + 1);

        pDshrToukeiLoadingTy.setZtysequenceno(keyKoumoku);

    }

    private void editDshrToukeiLoadingKoumoku(StDshrTukiTyukeiyouItzHznBean pStDshrTukiTyukeiyouItzHznBean,
        ZT_DshrToukeiLoadingTy pDshrToukeiLoadingTy) {

        pDshrToukeiLoadingTy.setZtydshrym(pStDshrTukiTyukeiyouItzHznBean.getZtydshrym());
        pDshrToukeiLoadingTy.setZtykeiyakunendo(pStDshrTukiTyukeiyouItzHznBean.getZtykeiyakunendo());
        pDshrToukeiLoadingTy.setZtyannaikigetu(pStDshrTukiTyukeiyouItzHznBean.getZtyannaikigetu());
        pDshrToukeiLoadingTy.setZtyhknsyruikbn(pStDshrTukiTyukeiyouItzHznBean.getZtyhknsyruikbn());
        pDshrToukeiLoadingTy.setZtysegcd(pStDshrTukiTyukeiyouItzHznBean.getZtysegcd());
        pDshrToukeiLoadingTy.setZtyshrriyuukbn(pStDshrTukiTyukeiyouItzHznBean.getZtyshrriyuukbn());
        pDshrToukeiLoadingTy.setZtyannaikbn(pStDshrTukiTyukeiyouItzHznBean.getZtyannaikbn());
        pDshrToukeiLoadingTy.setZtyduketorihouhoukbn(pStDshrTukiTyukeiyouItzHznBean.getZtyduketorihouhoukbn());
        pDshrToukeiLoadingTy.setZtysyoumetukbn(pStDshrTukiTyukeiyouItzHznBean.getZtysyoumetukbn());
        pDshrToukeiLoadingTy.setZtybikinhyj(pStDshrTukiTyukeiyouItzHznBean.getZtybikinhyj());
        pDshrToukeiLoadingTy.setZtyskskbn(pStDshrTukiTyukeiyouItzHznBean.getZtyskskbn());
        pDshrToukeiLoadingTy.setZtysrkensuu(pStDshrTukiTyukeiyouItzHznBean.getZtysrkensuu().intValue());
        pDshrToukeiLoadingTy.setZtysrhsys(pStDshrTukiTyukeiyouItzHznBean.getZtysrhsys());
        pDshrToukeiLoadingTy.setZtytoujigyounendod(pStDshrTukiTyukeiyouItzHznBean.getZtytoujigyounendod());
        pDshrToukeiLoadingTy.setZtytoujigyounendohasseidrsk(pStDshrTukiTyukeiyouItzHznBean.getZtytoujigyounendohasseidrsk());
        pDshrToukeiLoadingTy.setZtyzenjigyounendomatudzndk(pStDshrTukiTyukeiyouItzHznBean.getZtyzenjigyounendomatudzndk());
        pDshrToukeiLoadingTy.setZtyyokujigyounendod(pStDshrTukiTyukeiyouItzHznBean.getZtyyokujigyounendod());
        pDshrToukeiLoadingTy.setZtyhushrtoujigyounendod(pStDshrTukiTyukeiyouItzHznBean.getZtyhushrtoujigyounendod());
    }
}
