package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.mapping.GenIT_BAK_Tesuuryou;

import com.google.common.collect.Lists;


/**
 * 手数料情報バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_Tesuuryou} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_Tesuuryou<br />
 * @see     PKIT_BAK_Tesuuryou<br />
 * @see     QIT_BAK_Tesuuryou<br />
 * @see     GenQIT_BAK_Tesuuryou<br />
 */
@Entity
public class IT_BAK_Tesuuryou extends GenIT_BAK_Tesuuryou {

    private static final long serialVersionUID = 1L;

    public IT_BAK_Tesuuryou() {
    }

    public IT_BAK_Tesuuryou(String pKbnkey,String pSyono,String pTrkssikibetukey,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTsrysyorikbn,pRenno);
    }

    public IT_BAK_Tesuuryou(String pSyono,String pTrkssikibetukey,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTsrysyorikbn,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_Tesuuryou.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Tesuuryou.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Tesuuryou.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

    private List<IT_BAK_TesuuryouSyouhnRireki> iT_BAKTesuuryouSyouhnRirekis = Lists.newLinkedList();
    public IT_BAK_TesuuryouSyouhnRireki createBAKTesuuryouSyouhnRireki() {
        IT_BAK_TesuuryouSyouhnRireki bAKTesuuryouSyouhnRireki =  new IT_BAK_TesuuryouSyouhnRireki();
        bAKTesuuryouSyouhnRireki.setBAKTesuuryou(this);
        bAKTesuuryouSyouhnRireki.setKbnkey(this.getKbnkey());
        bAKTesuuryouSyouhnRireki.setSyono(this.getSyono());
        bAKTesuuryouSyouhnRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKTesuuryouSyouhnRireki.setTsrysyorikbn(this.getTsrysyorikbn());
        bAKTesuuryouSyouhnRireki.setRenno(this.getRenno());
        getBAKTesuuryouSyouhnRirekis().add(bAKTesuuryouSyouhnRireki);
        return bAKTesuuryouSyouhnRireki;
    }
    public void setBAKTesuuryouSyouhnRirekis(List<IT_BAK_TesuuryouSyouhnRireki> pIT_BAK_TesuuryouSyouhnRirekis) {
        this.iT_BAKTesuuryouSyouhnRirekis = pIT_BAK_TesuuryouSyouhnRirekis;
    }
    @OneToMany (
        mappedBy = "BAKTesuuryou",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(IT_BAK_TesuuryouSyouhnRireki.SYONO+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.TSRYSYORIKBN+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.RENNO+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.SYUTKKBN+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.SYOUHNCD+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.SYOUHNSDNO+" ASC ,"+IT_BAK_TesuuryouSyouhnRireki.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_BAK_TesuuryouSyouhnRireki> getBAKTesuuryouSyouhnRirekis() {
        return iT_BAKTesuuryouSyouhnRirekis;
    }

    private List<IT_BAK_TesuuryouSyouhn> iT_BAKTesuuryouSyouhns = Lists.newLinkedList();
    public IT_BAK_TesuuryouSyouhn createBAKTesuuryouSyouhn() {
        IT_BAK_TesuuryouSyouhn bAKTesuuryouSyouhn =  new IT_BAK_TesuuryouSyouhn();
        bAKTesuuryouSyouhn.setBAKTesuuryou(this);
        bAKTesuuryouSyouhn.setKbnkey(this.getKbnkey());
        bAKTesuuryouSyouhn.setSyono(this.getSyono());
        bAKTesuuryouSyouhn.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKTesuuryouSyouhn.setTsrysyorikbn(this.getTsrysyorikbn());
        bAKTesuuryouSyouhn.setRenno(this.getRenno());
        getBAKTesuuryouSyouhns().add(bAKTesuuryouSyouhn);
        return bAKTesuuryouSyouhn;
    }
    public void setBAKTesuuryouSyouhns(List<IT_BAK_TesuuryouSyouhn> pIT_BAK_TesuuryouSyouhns) {
        this.iT_BAKTesuuryouSyouhns = pIT_BAK_TesuuryouSyouhns;
    }
    @OneToMany (
        mappedBy = "BAKTesuuryou",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(IT_BAK_TesuuryouSyouhn.SYONO+" ASC ,"+IT_BAK_TesuuryouSyouhn.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_TesuuryouSyouhn.TSRYSYORIKBN+" ASC ,"+IT_BAK_TesuuryouSyouhn.RENNO+" ASC ,"+IT_BAK_TesuuryouSyouhn.SYUTKKBN+" ASC ,"+IT_BAK_TesuuryouSyouhn.SYOUHNCD+" ASC ,"+IT_BAK_TesuuryouSyouhn.SYOUHNSDNO+" ASC ,"+IT_BAK_TesuuryouSyouhn.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_BAK_TesuuryouSyouhn> getBAKTesuuryouSyouhns() {
        return iT_BAKTesuuryouSyouhns;
    }

}

