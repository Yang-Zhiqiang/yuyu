package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import yuyu.def.classification.C_KaisyoutaisyouKbn;

/**
 * 契約保全不備解消 - ●未解消不備一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class MikaisyouhubiListDataSourceBean extends GenMikaisyouhubiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public MikaisyouhubiListDataSourceBean() {
    }

    private Integer renno3keta;

    public Integer getRenno3ketay() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }
    @Override
    public void setDispkaisyoutaisyou(Boolean b){
        super.setDispkaisyoutaisyou(b);
        C_KaisyoutaisyouKbn kbn;
        if(b){
            kbn = C_KaisyoutaisyouKbn.TAISYOU;
        }
        else{
            kbn = C_KaisyoutaisyouKbn.TAISYOUGAI;
        }
        super.setDispkaisyoutaisyoukbn(kbn);
    }
}
