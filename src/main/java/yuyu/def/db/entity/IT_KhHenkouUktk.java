package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhHenkouUktk;

import com.google.common.collect.Lists;

/**
 * 契約保全変更受付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHenkouUktk} の JavaDoc を参照してください。
 * @see     GenIT_KhHenkouUktk
 * @see     PKIT_KhHenkouUktk
 * @see     QIT_KhHenkouUktk
 * @see     GenQIT_KhHenkouUktk
 */
@Entity
public class IT_KhHenkouUktk extends GenIT_KhHenkouUktk {

    private static final long serialVersionUID = 1L;

    public IT_KhHenkouUktk() {
    }

    public IT_KhHenkouUktk(String pKbnkey,String pSyono,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pHozenhenkouuktkrenno);
    }

    public IT_KhHenkouUktk(String pSyono,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHozenhenkouuktkrenno);
    }



    private List<IT_KhHenkouUktkKaiyaku> iT_KhHenkouUktkKaiyakus = Lists.newLinkedList();
    public IT_KhHenkouUktkKaiyaku createKhHenkouUktkKaiyaku() {
        IT_KhHenkouUktkKaiyaku khHenkouUktkKaiyaku =  new IT_KhHenkouUktkKaiyaku();
        khHenkouUktkKaiyaku.setKhHenkouUktk(this);
        khHenkouUktkKaiyaku.setKbnkey(this.getKbnkey());
        khHenkouUktkKaiyaku.setSyono(this.getSyono());
        khHenkouUktkKaiyaku.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setKhHenkouUktkKaiyaku(khHenkouUktkKaiyaku);
        return khHenkouUktkKaiyaku;
    }
    @Transient
    public  IT_KhHenkouUktkKaiyaku getKhHenkouUktkKaiyaku() {
        if(getKhHenkouUktkKaiyakus().size() == 0) {
            return null;
        }
        return getKhHenkouUktkKaiyakus().get(0);
    }
    @Transient
    public void setKhHenkouUktkKaiyaku(IT_KhHenkouUktkKaiyaku pIT_KhHenkouUktkKaiyaku) {
        if(this.getKhHenkouUktkKaiyakus().size() >0){
            this.getKhHenkouUktkKaiyakus().set(0, pIT_KhHenkouUktkKaiyaku) ;
        }else{
            this.getKhHenkouUktkKaiyakus().add(pIT_KhHenkouUktkKaiyaku) ;
        }
    }
    public void setKhHenkouUktkKaiyakus(List<IT_KhHenkouUktkKaiyaku> pIT_KhHenkouUktkKaiyakus) {
        this.iT_KhHenkouUktkKaiyakus = pIT_KhHenkouUktkKaiyakus;
    }
    @OneToMany (
        mappedBy = "khHenkouUktk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhHenkouUktkKaiyaku.SYONO+" ASC ,"+IT_KhHenkouUktkKaiyaku.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<IT_KhHenkouUktkKaiyaku> getKhHenkouUktkKaiyakus() {
        return iT_KhHenkouUktkKaiyakus;
    }

    private List<IT_KhHenkouUktkYendtHnk> iT_KhHenkouUktkYendtHnks = Lists.newLinkedList();
    public IT_KhHenkouUktkYendtHnk createKhHenkouUktkYendtHnk() {
        IT_KhHenkouUktkYendtHnk khHenkouUktkYendtHnk =  new IT_KhHenkouUktkYendtHnk();
        khHenkouUktkYendtHnk.setKhHenkouUktk(this);
        khHenkouUktkYendtHnk.setKbnkey(this.getKbnkey());
        khHenkouUktkYendtHnk.setSyono(this.getSyono());
        khHenkouUktkYendtHnk.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setKhHenkouUktkYendtHnk(khHenkouUktkYendtHnk);
        return khHenkouUktkYendtHnk;
    }
    @Transient
    public  IT_KhHenkouUktkYendtHnk getKhHenkouUktkYendtHnk() {
        if(getKhHenkouUktkYendtHnks().size() == 0) {
            return null;
        }
        return getKhHenkouUktkYendtHnks().get(0);
    }
    @Transient
    public void setKhHenkouUktkYendtHnk(IT_KhHenkouUktkYendtHnk pIT_KhHenkouUktkYendtHnk) {
        if(this.getKhHenkouUktkYendtHnks().size() >0){
            this.getKhHenkouUktkYendtHnks().set(0, pIT_KhHenkouUktkYendtHnk) ;
        }else{
            this.getKhHenkouUktkYendtHnks().add(pIT_KhHenkouUktkYendtHnk) ;
        }
    }
    public void setKhHenkouUktkYendtHnks(List<IT_KhHenkouUktkYendtHnk> pIT_KhHenkouUktkYendtHnks) {
        this.iT_KhHenkouUktkYendtHnks = pIT_KhHenkouUktkYendtHnks;
    }
    @OneToMany (
        mappedBy = "khHenkouUktk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhHenkouUktkYendtHnk.SYONO+" ASC ,"+IT_KhHenkouUktkYendtHnk.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<IT_KhHenkouUktkYendtHnk> getKhHenkouUktkYendtHnks() {
        return iT_KhHenkouUktkYendtHnks;
    }

    private List<IT_KhHenkouUktkMkhgkHnk> iT_KhHenkouUktkMkhgkHnks = Lists.newLinkedList();
    public IT_KhHenkouUktkMkhgkHnk createKhHenkouUktkMkhgkHnk() {
        IT_KhHenkouUktkMkhgkHnk khHenkouUktkMkhgkHnk =  new IT_KhHenkouUktkMkhgkHnk();
        khHenkouUktkMkhgkHnk.setKhHenkouUktk(this);
        khHenkouUktkMkhgkHnk.setKbnkey(this.getKbnkey());
        khHenkouUktkMkhgkHnk.setSyono(this.getSyono());
        khHenkouUktkMkhgkHnk.setHozenhenkouuktkrenno(this.getHozenhenkouuktkrenno());
        setKhHenkouUktkMkhgkHnk(khHenkouUktkMkhgkHnk);
        return khHenkouUktkMkhgkHnk;
    }
    @Transient
    public  IT_KhHenkouUktkMkhgkHnk getKhHenkouUktkMkhgkHnk() {
        if(getKhHenkouUktkMkhgkHnks().size() == 0) {
            return null;
        }
        return getKhHenkouUktkMkhgkHnks().get(0);
    }
    @Transient
    public void setKhHenkouUktkMkhgkHnk(IT_KhHenkouUktkMkhgkHnk pIT_KhHenkouUktkMkhgkHnk) {
        if(this.getKhHenkouUktkMkhgkHnks().size() >0){
            this.getKhHenkouUktkMkhgkHnks().set(0, pIT_KhHenkouUktkMkhgkHnk) ;
        }else{
            this.getKhHenkouUktkMkhgkHnks().add(pIT_KhHenkouUktkMkhgkHnk) ;
        }
    }
    public void setKhHenkouUktkMkhgkHnks(List<IT_KhHenkouUktkMkhgkHnk> pIT_KhHenkouUktkMkhgkHnks) {
        this.iT_KhHenkouUktkMkhgkHnks = pIT_KhHenkouUktkMkhgkHnks;
    }
    @OneToMany (
        mappedBy = "khHenkouUktk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhHenkouUktkMkhgkHnk.SYONO+" ASC ,"+IT_KhHenkouUktkMkhgkHnk.HOZENHENKOUUKTKRENNO+" ASC ")
    public  List<IT_KhHenkouUktkMkhgkHnk> getKhHenkouUktkMkhgkHnks() {
        return iT_KhHenkouUktkMkhgkHnks;
    }

}

