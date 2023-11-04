package yuyu.common.biz.syoruiitiran;

import yuyu.def.classification.C_HtysyoruiumuKbn;

/**
 * 業務共通 書類情報一覧 書類情報一覧設定CommonパラメータBean
 */
public class SyoruiInfoItiranDataSourceBeanCommonParamImpl implements SyoruiInfoItiranDataSourceBeanCommonParam{

    private String syoruittykymdtime;

    private String syoruinm;

    private C_HtysyoruiumuKbn htysyoruiumukbn;

    private String hyoujilink;

    private String hyoujilinkflg;

    private String imageid;

    private String torikomiSyoruiCd;

    @Override
    public String getSyoruittykymdtime() {
        return syoruittykymdtime;
    }

    @Override
    public void setSyoruittykymdtime(String syoruittykymdtime) {
        this.syoruittykymdtime = syoruittykymdtime;
    }

    @Override
    public String getSyoruinm() {
        return syoruinm;
    }

    @Override
    public void setSyoruinm(String syoruinm) {
        this.syoruinm = syoruinm;
    }

    @Override
    public C_HtysyoruiumuKbn getHtysyoruiumukbn() {
        return htysyoruiumukbn;
    }

    @Override
    public void setHtysyoruiumukbn(C_HtysyoruiumuKbn htysyoruiumukbn) {
        this.htysyoruiumukbn = htysyoruiumukbn;
    }

    @Override
    public String getHyoujilink() {
        return hyoujilink;
    }

    @Override
    public void setHyoujilink(String hyoujilink) {
        this.hyoujilink = hyoujilink;
    }

    @Override
    public String getHyoujilinkflg() {
        return hyoujilinkflg;
    }

    @Override
    public void setHyoujilinkflg(String hyoujilinkflg) {
        this.hyoujilinkflg = hyoujilinkflg;
    }

    @Override
    public String getImageid() {
        return imageid;
    }

    @Override
    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    @Override
    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    @Override
    public void setTorikomiSyoruiCd(String torikomiSyoruiCd) {
        this.torikomiSyoruiCd = torikomiSyoruiCd;
    }
}
