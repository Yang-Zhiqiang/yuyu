package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenSV_HoyuuMeisai;

import com.google.common.collect.Lists;

/**
 * 保有明細情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_HoyuuMeisai} の JavaDoc を参照してください。<br />
 * @see     GenSV_HoyuuMeisai<br />
 * @see     PKSV_HoyuuMeisai<br />
 * @see     QSV_HoyuuMeisai<br />
 * @see     GenQSV_HoyuuMeisai<br />
 */
@Entity
public class SV_HoyuuMeisai extends GenSV_HoyuuMeisai {

    private static final long serialVersionUID = 1L;

    public SV_HoyuuMeisai() {
    }

    public SV_HoyuuMeisai(String pSyono) {
        super(pSyono);
    }



    private List<IT_KykSyouhn> iT_KykSyouhns = Lists.newLinkedList();
    
    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_HoyuuMeisai.SYONO  , referencedColumnName=IT_KykSyouhn.SYONO, insertable=false, updatable=false)
    })
    
    @OrderBy(IT_KykSyouhn.SYONO+" ASC ,"+IT_KykSyouhn.SYUTKKBN+" ASC ,"+IT_KykSyouhn.SYOUHNCD+" ASC ,"+IT_KykSyouhn.SYOUHNSDNO+" ASC ,"+IT_KykSyouhn.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_KykSyouhn> getKykSyouhns() {
        return iT_KykSyouhns;
    }

    public void setKykSyouhns(List<IT_KykSyouhn> pIT_KykSyouhns) {
        this.iT_KykSyouhns = pIT_KykSyouhns;
    }


    private List<IT_KhBikinkanri> iT_KhBikinkanris = Lists.newLinkedList();
    
    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_HoyuuMeisai.SYONO  , referencedColumnName=IT_KhBikinkanri.SYONO, insertable=false, updatable=false)
    })
    
    @OrderBy(IT_KhBikinkanri.SYONO+" ASC ,"+IT_KhBikinkanri.KESSANKIJYUNYMD+" ASC ,"+IT_KhBikinkanri.BKNCDKBN+" ASC ,"+IT_KhBikinkanri.BKNKKTYMD+" ASC ,"+IT_KhBikinkanri.RENNO+" ASC ")
    public  List<IT_KhBikinkanri> getKhBikinkanris() {
        return iT_KhBikinkanris;
    }

    public void setKhBikinkanris(List<IT_KhBikinkanri> pIT_KhBikinkanris) {
        this.iT_KhBikinkanris = pIT_KhBikinkanris;
    }


    private List<JT_SiBikinkanri> jT_SiBikinkanris = Lists.newLinkedList();
    
    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_HoyuuMeisai.SYONO  , referencedColumnName=JT_SiBikinkanri.SYONO, insertable=false, updatable=false)
    })
    
    @OrderBy(JT_SiBikinkanri.SKNO+" ASC ,"+JT_SiBikinkanri.SYONO+" ASC ,"+JT_SiBikinkanri.KESSANKIJYUNYMD+" ASC ,"+JT_SiBikinkanri.BKNCDKBN+" ASC ,"+JT_SiBikinkanri.BKNKKTYMD+" ASC ,"+JT_SiBikinkanri.KYUUHUCD+" ASC ")
    public  List<JT_SiBikinkanri> getSiBikinkanris() {
        return jT_SiBikinkanris;
    }

    public void setSiBikinkanris(List<JT_SiBikinkanri> pJT_SiBikinkanris) {
        this.jT_SiBikinkanris = pJT_SiBikinkanris;
    }


}

