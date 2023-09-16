package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenSV_SibourituRendou;

import com.google.common.collect.Lists;

/**
 * 死亡率用連動情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_SibourituRendou} の JavaDoc を参照してください。<br />
 * @see     GenSV_SibourituRendou<br />
 * @see     PKSV_SibourituRendou<br />
 * @see     QSV_SibourituRendou<br />
 * @see     GenQSV_SibourituRendou<br />
 */
@Entity
public class SV_SibourituRendou extends GenSV_SibourituRendou {

    private static final long serialVersionUID = 1L;

    public SV_SibourituRendou() {
    }

    public SV_SibourituRendou(String pMosno) {
        super(pMosno);
    }



    private List<HT_MosSyouhn> hT_MosSyouhns = Lists.newLinkedList();

    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_SibourituRendou.MOSNO  , referencedColumnName=HT_MosSyouhn.MOSNO, insertable=false, updatable=false)
    })

    @OrderBy(HT_MosSyouhn.MOSNO+" ASC ,"+HT_MosSyouhn.SYOUHNCD+" ASC ")
    public  List<HT_MosSyouhn> getMosSyouhns() {
        return hT_MosSyouhns;
    }

    public void setMosSyouhns(List<HT_MosSyouhn> pHT_MosSyouhns) {
        this.hT_MosSyouhns = pHT_MosSyouhns;
    }


}

