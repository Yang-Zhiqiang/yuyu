package yuyu.def.db.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_SkHubiDetail;


/**
 * 新契約不備詳細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkHubiDetail} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkHubiDetail<br />
 * @see     PKHT_SkHubiDetail<br />
 * @see     QHT_SkHubiDetail<br />
 * @see     GenQHT_SkHubiDetail<br />
 */
@Entity
public class HT_SkHubiDetail extends GenHT_SkHubiDetail {

    private static final long serialVersionUID = 1L;

    public HT_SkHubiDetail() {
    }

    public HT_SkHubiDetail(String pMosno,String pHubisikibetukey,Integer pRenno3keta) {
        super(pMosno,pHubisikibetukey,pRenno3keta);
    }



    private HT_SkHubi hT_SkHubi ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SkHubiDetail.MOSNO  , referencedColumnName=HT_SkHubi.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=HT_SkHubiDetail.HUBISIKIBETUKEY  , referencedColumnName=HT_SkHubi.HUBISIKIBETUKEY, insertable=false, updatable=false)
    })
    public HT_SkHubi getSkHubi() {
        return hT_SkHubi;
    }

    public void setSkHubi(HT_SkHubi pHT_SkHubi) {
        this.hT_SkHubi = pHT_SkHubi;
    }

    private HM_SkHubiNaiyou hM_SkHubiNaiyou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SkHubiDetail.SKHUBIKOUMOKUCD  , referencedColumnName=HM_SkHubiNaiyou.SKHUBIKOUMOKUCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_SkHubiDetail.SKHUBINAIYOUCD  , referencedColumnName=HM_SkHubiNaiyou.SKHUBINAIYOUCD, insertable=false, updatable=false)
    })
    public  HM_SkHubiNaiyou getSkHubiNaiyou() {
        return hM_SkHubiNaiyou;
    }

    public void setSkHubiNaiyou(HM_SkHubiNaiyou pHM_SkHubiNaiyou) {
        this.hM_SkHubiNaiyou = pHM_SkHubiNaiyou;
    }

    private HM_SkHubiKoumoku hM_SkHubiKoumoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SkHubiDetail.SYORUICD  , referencedColumnName=HM_SkHubiKoumoku.SYORUICD, insertable=false, updatable=false),
        @JoinColumn(name=HT_SkHubiDetail.SKHUBIKOUMOKUCD  , referencedColumnName=HM_SkHubiKoumoku.SKHUBIKOUMOKUCD, insertable=false, updatable=false)
    })
    public  HM_SkHubiKoumoku getSkHubiKoumoku() {
        return hM_SkHubiKoumoku;
    }

    public void setSkHubiKoumoku(HM_SkHubiKoumoku pHM_SkHubiKoumoku) {
        this.hM_SkHubiKoumoku = pHM_SkHubiKoumoku;
    }

    private HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SkHubiDetail.SKSEIBISIJINAIYOUCD  , referencedColumnName=HM_SkSeibiSijiNaiyou.SKSEIBISIJINAIYOUCD, insertable=false, updatable=false)
    })
    public  HM_SkSeibiSijiNaiyou getSkSeibiSijiNaiyou() {
        return hM_SkSeibiSijiNaiyou;
    }

    public void setSkSeibiSijiNaiyou(HM_SkSeibiSijiNaiyou pHM_SkSeibiSijiNaiyou) {
        this.hM_SkSeibiSijiNaiyou = pHM_SkSeibiSijiNaiyou;
    }

    private AM_User aM_User ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SkHubiDetail.GYOUMUKOUSINSYAID  , referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    })
    public  AM_User getUser() {
        return aM_User;
    }

    public void setUser(AM_User pAM_User) {
        this.aM_User = pAM_User;
    }

}

