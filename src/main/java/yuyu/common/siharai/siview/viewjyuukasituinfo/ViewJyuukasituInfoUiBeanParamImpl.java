package yuyu.common.siharai.siview.viewjyuukasituinfo;

import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 支払画面部品 重過失情報表示 <br />
 */
public class ViewJyuukasituInfoUiBeanParamImpl implements ViewJyuukasituInfoUiBeanParam{

    private Boolean juukasitucheck1;

    private C_UmuKbn juukasitucheckkbn1;

    private String juukasitucheckcomment1;

    private Boolean juukasitucheck2;

    private C_UmuKbn juukasitucheckkbn2;

    private String juukasitucheckcomment2;

    private Boolean juukasitucheck3;

    private C_UmuKbn juukasitucheckkbn3;

    private String juukasitucheckcomment3;

    private Boolean juukasitucheck4;

    private C_UmuKbn juukasitucheckkbn4;

    private String juukasitucheckcomment4;

    private boolean viewJyuukasituInfoFlg;

    private boolean viewJyuukasituInfoSeigyo;

    private boolean viewJyuukasituInfoDispFlg;

    private boolean viewJyuukasituInfoInputDispFlg;

    @Override
    public Boolean getJuukasitucheck1() {
        return (juukasitucheck1 == null) ? Boolean.FALSE : juukasitucheck1;
    }

    @Override
    public void setJuukasitucheck1(Boolean pJuukasitucheck1) {
        juukasitucheck1 = (pJuukasitucheck1 == null) ? Boolean.FALSE : pJuukasitucheck1;
    }

    public C_UmuKbn getJuukasitucheckkbn1() {
        return juukasitucheckkbn1;
    }

    public void setJuukasitucheckkbn1(C_UmuKbn pJuukasitucheckkbn1) {
        if (C_UmuKbn.ARI.eq(pJuukasitucheckkbn1)) {
            this.setJuukasitucheck1(true);
        }
        else {
            this.setJuukasitucheck1(false);
        }
        juukasitucheckkbn1 = pJuukasitucheckkbn1;
    }

    @Override
    public String getJuukasitucheckcomment1() {
        return juukasitucheckcomment1;
    }

    @Override
    public void setJuukasitucheckcomment1(String pJuukasitucheckcomment1) {
        juukasitucheckcomment1 = pJuukasitucheckcomment1;
    }

    @Override
    public Boolean getJuukasitucheck2() {
        return (juukasitucheck2 == null) ? Boolean.FALSE : juukasitucheck2;
    }

    @Override
    public void setJuukasitucheck2(Boolean pJuukasitucheck2) {
        juukasitucheck2 = (pJuukasitucheck2 == null) ? Boolean.FALSE : pJuukasitucheck2;
    }

    public C_UmuKbn getJuukasitucheckkbn2() {
        return juukasitucheckkbn2;
    }

    public void setJuukasitucheckkbn2(C_UmuKbn pJuukasitucheckkbn2) {
        if (C_UmuKbn.ARI.eq(pJuukasitucheckkbn2)) {
            this.setJuukasitucheck2(true);
        }
        else {
            this.setJuukasitucheck2(false);
        }
        juukasitucheckkbn2 = pJuukasitucheckkbn2;
    }

    @Override
    public String getJuukasitucheckcomment2() {
        return juukasitucheckcomment2;
    }

    @Override
    public void setJuukasitucheckcomment2(String pJuukasitucheckcomment2) {
        juukasitucheckcomment2 = pJuukasitucheckcomment2;
    }

    @Override
    public Boolean getJuukasitucheck3() {
        return (juukasitucheck3 == null) ? Boolean.FALSE : juukasitucheck3;
    }

    @Override
    public void setJuukasitucheck3(Boolean pJuukasitucheck3) {
        juukasitucheck3 = (pJuukasitucheck3 == null) ? Boolean.FALSE : pJuukasitucheck3;
    }

    public C_UmuKbn getJuukasitucheckkbn3() {
        return juukasitucheckkbn3;
    }

    public void setJuukasitucheckkbn3(C_UmuKbn pJuukasitucheckkbn3) {
        if (C_UmuKbn.ARI.eq(pJuukasitucheckkbn3)) {
            this.setJuukasitucheck3(true);
        }
        else {
            this.setJuukasitucheck3(false);
        }
        juukasitucheckkbn3 = pJuukasitucheckkbn3;
    }

    @Override
    public String getJuukasitucheckcomment3() {
        return juukasitucheckcomment3;
    }

    @Override
    public void setJuukasitucheckcomment3(String pJuukasitucheckcomment3) {
        juukasitucheckcomment3 = pJuukasitucheckcomment3;
    }

    @Override
    public Boolean getJuukasitucheck4() {
        return (juukasitucheck4 == null) ? Boolean.FALSE : juukasitucheck4;
    }

    @Override
    public void setJuukasitucheck4(Boolean pJuukasitucheck4) {
        juukasitucheck4 = (pJuukasitucheck4 == null) ? Boolean.FALSE : pJuukasitucheck4;
    }

    public C_UmuKbn getJuukasitucheckkbn4() {
        return juukasitucheckkbn4;
    }

    public void setJuukasitucheckkbn4(C_UmuKbn pJuukasitucheckkbn4) {
        if (C_UmuKbn.ARI.eq(pJuukasitucheckkbn4)) {
            this.setJuukasitucheck4(true);
        }
        else {
            this.setJuukasitucheck4(false);
        }
        juukasitucheckkbn4 = pJuukasitucheckkbn4;
    }

    @Override
    public String getJuukasitucheckcomment4() {
        return juukasitucheckcomment4;
    }

    @Override
    public void setJuukasitucheckcomment4(String pJuukasitucheckcomment4) {
        juukasitucheckcomment4 = pJuukasitucheckcomment4;
    }

    @Override
    public boolean isViewJyuukasituInfoFlg() {
        return viewJyuukasituInfoFlg;
    }

    @Override
    public boolean isViewJyuukasituInfoSeigyo() {
        return viewJyuukasituInfoSeigyo;
    }

    @Override
    public boolean isViewJyuukasituInfoDispFlg() {
        return viewJyuukasituInfoDispFlg;
    }

    @Override
    public boolean isViewJyuukasituInfoInputDispFlg() {
        return viewJyuukasituInfoInputDispFlg;
    }
}
