package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.common.suuri.srcommon.SinkeiyakuSeirituInfoParam;
import yuyu.def.db.mapping.GenSV_SnkiykGtjSirt;

import com.google.common.collect.Lists;

/**
 * 新契約決算ベース月次成立情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_SnkiykGtjSirt} の JavaDoc を参照してください。<br />
 * @see     GenSV_SnkiykGtjSirt<br />
 * @see     PKSV_SnkiykGtjSirt<br />
 * @see     QSV_SnkiykGtjSirt<br />
 * @see     GenQSV_SnkiykGtjSirt<br />
 */
@Entity
public class SV_SnkiykGtjSirt extends GenSV_SnkiykGtjSirt implements SinkeiyakuSeirituInfoParam {

    private static final long serialVersionUID = 1L;

    public SV_SnkiykGtjSirt() {
    }

    public SV_SnkiykGtjSirt(String pMosno) {
        super(pMosno);
    }



    private List<HT_MosSyouhn> hT_MosSyouhns = Lists.newLinkedList();

    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_SnkiykGtjSirt.MOSNO  , referencedColumnName=HT_MosSyouhn.MOSNO, insertable=false, updatable=false)
    })

    @OrderBy(HT_MosSyouhn.MOSNO+" ASC ,"+HT_MosSyouhn.SYOUHNCD+" ASC ")
    public  List<HT_MosSyouhn> getMosSyouhns() {
        return hT_MosSyouhns;
    }

    public void setMosSyouhns(List<HT_MosSyouhn> pHT_MosSyouhns) {
        this.hT_MosSyouhns = pHT_MosSyouhns;
    }


    private List<HT_MosDairiten> hT_MosDairitens = Lists.newLinkedList();

    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_SnkiykGtjSirt.MOSNO  , referencedColumnName=HT_MosDairiten.MOSNO, insertable=false, updatable=false)
    })

    @OrderBy(HT_MosDairiten.MOSNO+" ASC ,"+HT_MosDairiten.RENNO+" ASC ")
    public  List<HT_MosDairiten> getMosDairitens() {
        return hT_MosDairitens;
    }

    public void setMosDairitens(List<HT_MosDairiten> pHT_MosDairitens) {
        this.hT_MosDairitens = pHT_MosDairitens;
    }


}

