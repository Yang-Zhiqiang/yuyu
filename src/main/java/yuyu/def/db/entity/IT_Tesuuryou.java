package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.mapping.GenIT_Tesuuryou;
import yuyu.def.hozen.predicate.FilterTesuuryouSyouhnRirekiBySyutkkbn;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;


/**
 * 手数料情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_Tesuuryou} の JavaDoc を参照してください。<br />
 * @see     GenIT_Tesuuryou<br />
 * @see     PKIT_Tesuuryou<br />
 * @see     QIT_Tesuuryou<br />
 * @see     GenQIT_Tesuuryou<br />
 */
@Entity
public class IT_Tesuuryou extends GenIT_Tesuuryou {

    private static final long serialVersionUID = 1L;

    public IT_Tesuuryou() {
    }

    public IT_Tesuuryou(String pKbnkey,String pSyono,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno) {
        super(pKbnkey,pSyono,pTsrysyorikbn,pRenno);
    }

    public IT_Tesuuryou(String pSyono,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTsrysyorikbn,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_Tesuuryou.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_Tesuuryou.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

    private List<IT_TesuuryouSyouhnRireki> iT_TesuuryouSyouhnRirekis = Lists.newLinkedList();
    public IT_TesuuryouSyouhnRireki createTesuuryouSyouhnRireki() {
        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki =  new IT_TesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki.setTesuuryou(this);
        tesuuryouSyouhnRireki.setKbnkey(this.getKbnkey());
        tesuuryouSyouhnRireki.setSyono(this.getSyono());
        tesuuryouSyouhnRireki.setTsrysyorikbn(this.getTsrysyorikbn());
        tesuuryouSyouhnRireki.setRenno(this.getRenno());
        getTesuuryouSyouhnRirekis().add(tesuuryouSyouhnRireki);
        return tesuuryouSyouhnRireki;
    }
    public void setTesuuryouSyouhnRirekis(List<IT_TesuuryouSyouhnRireki> pIT_TesuuryouSyouhnRirekis) {
        this.iT_TesuuryouSyouhnRirekis = pIT_TesuuryouSyouhnRirekis;
    }
    @OneToMany (
        mappedBy = "tesuuryou",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_TesuuryouSyouhnRireki.SYONO+" ASC ,"+IT_TesuuryouSyouhnRireki.TSRYSYORIKBN+" ASC ,"+IT_TesuuryouSyouhnRireki.RENNO+" ASC ,"+IT_TesuuryouSyouhnRireki.SYUTKKBN+" ASC ,"+IT_TesuuryouSyouhnRireki.SYOUHNCD+" ASC ,"+IT_TesuuryouSyouhnRireki.SYOUHNSDNO+" ASC ,"+IT_TesuuryouSyouhnRireki.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_TesuuryouSyouhnRireki> getTesuuryouSyouhnRirekis() {
        return iT_TesuuryouSyouhnRirekis;
    }

    private List<IT_TesuuryouSyouhn> iT_TesuuryouSyouhns = Lists.newLinkedList();
    public IT_TesuuryouSyouhn createTesuuryouSyouhn() {
        IT_TesuuryouSyouhn tesuuryouSyouhn =  new IT_TesuuryouSyouhn();
        tesuuryouSyouhn.setTesuuryou(this);
        tesuuryouSyouhn.setKbnkey(this.getKbnkey());
        tesuuryouSyouhn.setSyono(this.getSyono());
        tesuuryouSyouhn.setTsrysyorikbn(this.getTsrysyorikbn());
        tesuuryouSyouhn.setRenno(this.getRenno());
        getTesuuryouSyouhns().add(tesuuryouSyouhn);
        return tesuuryouSyouhn;
    }
    public void setTesuuryouSyouhns(List<IT_TesuuryouSyouhn> pIT_TesuuryouSyouhns) {
        this.iT_TesuuryouSyouhns = pIT_TesuuryouSyouhns;
    }
    @OneToMany (
        mappedBy = "tesuuryou",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_TesuuryouSyouhn.SYONO+" ASC ,"+IT_TesuuryouSyouhn.TSRYSYORIKBN+" ASC ,"+IT_TesuuryouSyouhn.RENNO+" ASC ,"+IT_TesuuryouSyouhn.SYUTKKBN+" ASC ,"+IT_TesuuryouSyouhn.SYOUHNCD+" ASC ,"+IT_TesuuryouSyouhn.SYOUHNSDNO+" ASC ,"+IT_TesuuryouSyouhn.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_TesuuryouSyouhn> getTesuuryouSyouhns() {
        return iT_TesuuryouSyouhns;
    }

    @Transient
    public  List<IT_TesuuryouSyouhnRireki> getTesuuryouSyouhnRirekisBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return new ArrayList<IT_TesuuryouSyouhnRireki>(Collections2.filter(getTesuuryouSyouhnRirekis(),
            new FilterTesuuryouSyouhnRirekiBySyutkkbn(pSyutkkbn)));
    }
}

