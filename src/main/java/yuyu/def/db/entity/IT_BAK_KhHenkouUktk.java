package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouUktk;

import com.google.common.collect.Lists;

/**
 * 契約保全変更受付バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhHenkouUktk} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhHenkouUktk<br />
 * @see     PKIT_BAK_KhHenkouUktk<br />
 * @see     QIT_BAK_KhHenkouUktk<br />
 * @see     GenQIT_BAK_KhHenkouUktk<br />
 */
@Entity
public class IT_BAK_KhHenkouUktk extends GenIT_BAK_KhHenkouUktk {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhHenkouUktk() {
    }

    public IT_BAK_KhHenkouUktk(String pKbnkey,String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }

    public IT_BAK_KhHenkouUktk(String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }


    private List<IT_BAK_KhHenkouUktkKaiyaku> iT_BAKKhHenkouUktkKaiyakus = Lists.newLinkedList();
    public IT_BAK_KhHenkouUktkKaiyaku createBAKKhHenkouUktkKaiyaku() {
        IT_BAK_KhHenkouUktkKaiyaku bAKKhHenkouUktkKaiyaku =  new IT_BAK_KhHenkouUktkKaiyaku();
        bAKKhHenkouUktkKaiyaku.setBAKKhHenkouUktk(this);
        bAKKhHenkouUktkKaiyaku.setKbnkey(this.getKbnkey());
        bAKKhHenkouUktkKaiyaku.setSyono(this.getSyono());
        bAKKhHenkouUktkKaiyaku.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhHenkouUktkKaiyaku.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setBAKKhHenkouUktkKaiyaku(bAKKhHenkouUktkKaiyaku);
        return bAKKhHenkouUktkKaiyaku;
    }
    @Transient
    public  IT_BAK_KhHenkouUktkKaiyaku getBAKKhHenkouUktkKaiyaku() {
        if(getBAKKhHenkouUktkKaiyakus().size() == 0) {
            return null;
        }
        return getBAKKhHenkouUktkKaiyakus().get(0);
    }
    @Transient
    public void setBAKKhHenkouUktkKaiyaku(IT_BAK_KhHenkouUktkKaiyaku pIT_BAK_KhHenkouUktkKaiyaku) {
        if(this.getBAKKhHenkouUktkKaiyakus().size() >0){
            this.getBAKKhHenkouUktkKaiyakus().set(0, pIT_BAK_KhHenkouUktkKaiyaku) ;
        }else{
            this.getBAKKhHenkouUktkKaiyakus().add(pIT_BAK_KhHenkouUktkKaiyaku) ;
        }
    }
    public void setBAKKhHenkouUktkKaiyakus(List<IT_BAK_KhHenkouUktkKaiyaku> pIT_BAK_KhHenkouUktkKaiyakus) {
        this.iT_BAKKhHenkouUktkKaiyakus = pIT_BAK_KhHenkouUktkKaiyakus;
    }
    @OneToMany (
        mappedBy = "BAKKhHenkouUktk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhHenkouUktkKaiyaku.SYONO+" ASC ,"+IT_BAK_KhHenkouUktkKaiyaku.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhHenkouUktkKaiyaku.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<IT_BAK_KhHenkouUktkKaiyaku> getBAKKhHenkouUktkKaiyakus() {
        return iT_BAKKhHenkouUktkKaiyakus;
    }

    private List<IT_BAK_KhHenkouUktkYendtHnk> iT_BAKKhHenkouUktkYendtHnks = Lists.newLinkedList();
    public IT_BAK_KhHenkouUktkYendtHnk createBAKKhHenkouUktkYendtHnk() {
        IT_BAK_KhHenkouUktkYendtHnk bAKKhHenkouUktkYendtHnk =  new IT_BAK_KhHenkouUktkYendtHnk();
        bAKKhHenkouUktkYendtHnk.setBAKKhHenkouUktk(this);
        bAKKhHenkouUktkYendtHnk.setKbnkey(this.getKbnkey());
        bAKKhHenkouUktkYendtHnk.setSyono(this.getSyono());
        bAKKhHenkouUktkYendtHnk.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhHenkouUktkYendtHnk.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setBAKKhHenkouUktkYendtHnk(bAKKhHenkouUktkYendtHnk);
        return bAKKhHenkouUktkYendtHnk;
    }
    @Transient
    public  IT_BAK_KhHenkouUktkYendtHnk getBAKKhHenkouUktkYendtHnk() {
        if(getBAKKhHenkouUktkYendtHnks().size() == 0) {
            return null;
        }
        return getBAKKhHenkouUktkYendtHnks().get(0);
    }
    @Transient
    public void setBAKKhHenkouUktkYendtHnk(IT_BAK_KhHenkouUktkYendtHnk pIT_BAK_KhHenkouUktkYendtHnk) {
        if(this.getBAKKhHenkouUktkYendtHnks().size() >0){
            this.getBAKKhHenkouUktkYendtHnks().set(0, pIT_BAK_KhHenkouUktkYendtHnk) ;
        }else{
            this.getBAKKhHenkouUktkYendtHnks().add(pIT_BAK_KhHenkouUktkYendtHnk) ;
        }
    }
    public void setBAKKhHenkouUktkYendtHnks(List<IT_BAK_KhHenkouUktkYendtHnk> pIT_BAK_KhHenkouUktkYendtHnks) {
        this.iT_BAKKhHenkouUktkYendtHnks = pIT_BAK_KhHenkouUktkYendtHnks;
    }
    @OneToMany (
        mappedBy = "BAKKhHenkouUktk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhHenkouUktkYendtHnk.SYONO+" ASC ,"+IT_BAK_KhHenkouUktkYendtHnk.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhHenkouUktkYendtHnk.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<IT_BAK_KhHenkouUktkYendtHnk> getBAKKhHenkouUktkYendtHnks() {
        return iT_BAKKhHenkouUktkYendtHnks;
    }

    private List<IT_BAK_KhHenkouUktkMkhgkHnk> iT_BAKKhHenkouUktkMkhgkHnks = Lists.newLinkedList();
    public IT_BAK_KhHenkouUktkMkhgkHnk createBAKKhHenkouUktkMkhgkHnk() {
        IT_BAK_KhHenkouUktkMkhgkHnk bAKKhHenkouUktkMkhgkHnk =  new IT_BAK_KhHenkouUktkMkhgkHnk();
        bAKKhHenkouUktkMkhgkHnk.setBAKKhHenkouUktk(this);
        bAKKhHenkouUktkMkhgkHnk.setKbnkey(this.getKbnkey());
        bAKKhHenkouUktkMkhgkHnk.setSyono(this.getSyono());
        bAKKhHenkouUktkMkhgkHnk.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKKhHenkouUktkMkhgkHnk.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setBAKKhHenkouUktkMkhgkHnk(bAKKhHenkouUktkMkhgkHnk);
        return bAKKhHenkouUktkMkhgkHnk;
    }
    @Transient
    public  IT_BAK_KhHenkouUktkMkhgkHnk getBAKKhHenkouUktkMkhgkHnk() {
        if(getBAKKhHenkouUktkMkhgkHnks().size() == 0) {
            return null;
        }
        return getBAKKhHenkouUktkMkhgkHnks().get(0);
    }
    @Transient
    public void setBAKKhHenkouUktkMkhgkHnk(IT_BAK_KhHenkouUktkMkhgkHnk pIT_BAK_KhHenkouUktkMkhgkHnk) {
        if(this.getBAKKhHenkouUktkMkhgkHnks().size() >0){
            this.getBAKKhHenkouUktkMkhgkHnks().set(0, pIT_BAK_KhHenkouUktkMkhgkHnk) ;
        }else{
            this.getBAKKhHenkouUktkMkhgkHnks().add(pIT_BAK_KhHenkouUktkMkhgkHnk) ;
        }
    }
    public void setBAKKhHenkouUktkMkhgkHnks(List<IT_BAK_KhHenkouUktkMkhgkHnk> pIT_BAK_KhHenkouUktkMkhgkHnks) {
        this.iT_BAKKhHenkouUktkMkhgkHnks = pIT_BAK_KhHenkouUktkMkhgkHnks;
    }
    @OneToMany (
        mappedBy = "BAKKhHenkouUktk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhHenkouUktkMkhgkHnk.SYONO+" ASC ,"+IT_BAK_KhHenkouUktkMkhgkHnk.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhHenkouUktkMkhgkHnk.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<IT_BAK_KhHenkouUktkMkhgkHnk> getBAKKhHenkouUktkMkhgkHnks() {
        return iT_BAKKhHenkouUktkMkhgkHnks;
    }

}

