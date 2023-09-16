package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenMT_BAK_DsKokyakuKanri;

import com.google.common.collect.Lists;

/**
 * ＤＳ顧客管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_BAK_DsKokyakuKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_BAK_DsKokyakuKanri<br />
 * @see     PKMT_BAK_DsKokyakuKanri<br />
 * @see     QMT_BAK_DsKokyakuKanri<br />
 * @see     GenQMT_BAK_DsKokyakuKanri<br />
 */
@Entity
public class MT_BAK_DsKokyakuKanri extends GenMT_BAK_DsKokyakuKanri {

    private static final long serialVersionUID = 1L;

    public MT_BAK_DsKokyakuKanri() {
    }

    public MT_BAK_DsKokyakuKanri(String pDskokno,String pTrkssikibetukey) {
        super(pDskokno,pTrkssikibetukey);
    }



    private List<MT_BAK_DsHonninKakuninCd> mT_BAKDsHonninKakuninCds = Lists.newLinkedList();
    public MT_BAK_DsHonninKakuninCd createBAKDsHonninKakuninCd() {
        MT_BAK_DsHonninKakuninCd bAKDsHonninKakuninCd =  new MT_BAK_DsHonninKakuninCd();
        bAKDsHonninKakuninCd.setBAKDsKokyakuKanri(this);
        bAKDsHonninKakuninCd.setDskokno(this.getDskokno());
        bAKDsHonninKakuninCd.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKDsHonninKakuninCd(bAKDsHonninKakuninCd);
        return bAKDsHonninKakuninCd;
    }
    @Transient
    public  MT_BAK_DsHonninKakuninCd getBAKDsHonninKakuninCd() {
        requiredEntities(getBAKDsHonninKakuninCds(),MT_BAK_DsHonninKakuninCd.class);
        if(getBAKDsHonninKakuninCds().size() == 0) {
            return null;
        }
        return getBAKDsHonninKakuninCds().get(0);
    }
    @Transient
    public void setBAKDsHonninKakuninCd(MT_BAK_DsHonninKakuninCd pMT_BAK_DsHonninKakuninCd) {
        if(this.getBAKDsHonninKakuninCds().size() >0){
            this.getBAKDsHonninKakuninCds().set(0, pMT_BAK_DsHonninKakuninCd) ;
        }else{
            this.getBAKDsHonninKakuninCds().add(pMT_BAK_DsHonninKakuninCd) ;
        }
    }
    public void setBAKDsHonninKakuninCds(List<MT_BAK_DsHonninKakuninCd> pMT_BAK_DsHonninKakuninCds) {
        this.mT_BAKDsHonninKakuninCds = pMT_BAK_DsHonninKakuninCds;
    }
    @OneToMany (
        mappedBy = "BAKDsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsHonninKakuninCd.DSKOKNO+" ASC ,"+MT_BAK_DsHonninKakuninCd.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsHonninKakuninCd> getBAKDsHonninKakuninCds() {
        return mT_BAKDsHonninKakuninCds;
    }

    private List<MT_BAK_DsKokyakuKeiyaku> mT_BAKDsKokyakuKeiyakus = Lists.newLinkedList();
    public MT_BAK_DsKokyakuKeiyaku createBAKDsKokyakuKeiyaku() {
        MT_BAK_DsKokyakuKeiyaku bAKDsKokyakuKeiyaku =  new MT_BAK_DsKokyakuKeiyaku();
        bAKDsKokyakuKeiyaku.setBAKDsKokyakuKanri(this);
        bAKDsKokyakuKeiyaku.setDskokno(this.getDskokno());
        bAKDsKokyakuKeiyaku.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKDsKokyakuKeiyakus().add(bAKDsKokyakuKeiyaku);
        return bAKDsKokyakuKeiyaku;
    }
    public void setBAKDsKokyakuKeiyakus(List<MT_BAK_DsKokyakuKeiyaku> pMT_BAK_DsKokyakuKeiyakus) {
        this.mT_BAKDsKokyakuKeiyakus = pMT_BAK_DsKokyakuKeiyakus;
    }
    @OneToMany (
        mappedBy = "BAKDsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsKokyakuKeiyaku.DSKOKNO+" ASC ,"+MT_BAK_DsKokyakuKeiyaku.SYONO+" ASC ,"+MT_BAK_DsKokyakuKeiyaku.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsKokyakuKeiyaku> getBAKDsKokyakuKeiyakus() {
        return mT_BAKDsKokyakuKeiyakus;
    }

    private List<MT_BAK_DsLoginKanri> mT_BAKDsLoginKanris = Lists.newLinkedList();
    public MT_BAK_DsLoginKanri createBAKDsLoginKanri() {
        MT_BAK_DsLoginKanri bAKDsLoginKanri =  new MT_BAK_DsLoginKanri();
        bAKDsLoginKanri.setBAKDsKokyakuKanri(this);
        bAKDsLoginKanri.setDskokno(this.getDskokno());
        bAKDsLoginKanri.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKDsLoginKanri(bAKDsLoginKanri);
        return bAKDsLoginKanri;
    }
    @Transient
    public  MT_BAK_DsLoginKanri getBAKDsLoginKanri() {
        requiredEntities(getBAKDsLoginKanris(),MT_BAK_DsLoginKanri.class);
        if(getBAKDsLoginKanris().size() == 0) {
            return null;
        }
        return getBAKDsLoginKanris().get(0);
    }
    @Transient
    public void setBAKDsLoginKanri(MT_BAK_DsLoginKanri pMT_BAK_DsLoginKanri) {
        if(this.getBAKDsLoginKanris().size() >0){
            this.getBAKDsLoginKanris().set(0, pMT_BAK_DsLoginKanri) ;
        }else{
            this.getBAKDsLoginKanris().add(pMT_BAK_DsLoginKanri) ;
        }
    }
    public void setBAKDsLoginKanris(List<MT_BAK_DsLoginKanri> pMT_BAK_DsLoginKanris) {
        this.mT_BAKDsLoginKanris = pMT_BAK_DsLoginKanris;
    }
    @OneToMany (
        mappedBy = "BAKDsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsLoginKanri.DSKOKNO+" ASC ,"+MT_BAK_DsLoginKanri.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsLoginKanri> getBAKDsLoginKanris() {
        return mT_BAKDsLoginKanris;
    }

    private List<MT_BAK_DsMailAddress> mT_BAKDsMailAddresss = Lists.newLinkedList();
    public MT_BAK_DsMailAddress createBAKDsMailAddress() {
        MT_BAK_DsMailAddress bAKDsMailAddress =  new MT_BAK_DsMailAddress();
        bAKDsMailAddress.setBAKDsKokyakuKanri(this);
        bAKDsMailAddress.setDskokno(this.getDskokno());
        bAKDsMailAddress.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKDsMailAddresss().add(bAKDsMailAddress);
        return bAKDsMailAddress;
    }
    public void setBAKDsMailAddresss(List<MT_BAK_DsMailAddress> pMT_BAK_DsMailAddresss) {
        this.mT_BAKDsMailAddresss = pMT_BAK_DsMailAddresss;
    }
    @OneToMany (
        mappedBy = "BAKDsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsMailAddress.DSKOKNO+" ASC ,"+MT_BAK_DsMailAddress.DSMAILADDRESSRENBAN+" ASC ,"+MT_BAK_DsMailAddress.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsMailAddress> getBAKDsMailAddresss() {
        return mT_BAKDsMailAddresss;
    }

}

