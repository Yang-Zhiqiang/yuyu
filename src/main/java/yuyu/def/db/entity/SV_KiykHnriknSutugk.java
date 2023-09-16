package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenSV_KiykHnriknSutugk;

import com.google.common.collect.Lists;

/**
 * 解約返戻金相当額情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_KiykHnriknSutugk} の JavaDoc を参照してください。<br />
 * @see     GenSV_KiykHnriknSutugk<br />
 * @see     PKSV_KiykHnriknSutugk<br />
 * @see     QSV_KiykHnriknSutugk<br />
 * @see     GenQSV_KiykHnriknSutugk<br />
 */
@Entity
public class SV_KiykHnriknSutugk extends GenSV_KiykHnriknSutugk {

    private static final long serialVersionUID = 1L;

    public SV_KiykHnriknSutugk() {
    }

    public SV_KiykHnriknSutugk(String pSyono) {
        super(pSyono);
    }



    private List<IT_KykSyouhn> iT_KykSyouhns = Lists.newLinkedList();
    
    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_KiykHnriknSutugk.SYONO  , referencedColumnName=IT_KykSyouhn.SYONO, insertable=false, updatable=false)
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
        @JoinColumn(name=SV_KiykHnriknSutugk.SYONO  , referencedColumnName=IT_KhBikinkanri.SYONO, insertable=false, updatable=false)
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
        @JoinColumn(name=SV_KiykHnriknSutugk.SYONO  , referencedColumnName=JT_SiBikinkanri.SYONO, insertable=false, updatable=false)
    })
    
    @OrderBy(JT_SiBikinkanri.SKNO+" ASC ,"+JT_SiBikinkanri.SYONO+" ASC ,"+JT_SiBikinkanri.KESSANKIJYUNYMD+" ASC ,"+JT_SiBikinkanri.BKNCDKBN+" ASC ,"+JT_SiBikinkanri.BKNKKTYMD+" ASC ,"+JT_SiBikinkanri.KYUUHUCD+" ASC ")
    public  List<JT_SiBikinkanri> getSiBikinkanris() {
        return jT_SiBikinkanris;
    }

    public void setSiBikinkanris(List<JT_SiBikinkanri> pJT_SiBikinkanris) {
        this.jT_SiBikinkanris = pJT_SiBikinkanris;
    }


}

