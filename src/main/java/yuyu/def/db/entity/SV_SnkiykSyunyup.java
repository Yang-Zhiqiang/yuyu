package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenSV_SnkiykSyunyup;

import com.google.common.collect.Lists;

/**
 * 新契約収入Ｐ統計情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_SnkiykSyunyup} の JavaDoc を参照してください。<br />
 * @see     GenSV_SnkiykSyunyup<br />
 * @see     PKSV_SnkiykSyunyup<br />
 * @see     QSV_SnkiykSyunyup<br />
 * @see     GenQSV_SnkiykSyunyup<br />
 */
@Entity
public class SV_SnkiykSyunyup extends GenSV_SnkiykSyunyup {

    private static final long serialVersionUID = 1L;

    public SV_SnkiykSyunyup() {
    }

    public SV_SnkiykSyunyup(String pMosno) {
        super(pMosno);
    }



    private List<HT_MosSyouhn> hT_MosSyouhns = Lists.newLinkedList();
    
    @OneToMany
    @JoinColumns({
        @JoinColumn(name=SV_SnkiykSyunyup.MOSNO  , referencedColumnName=HT_MosSyouhn.MOSNO, insertable=false, updatable=false)
    })
    
    @OrderBy(HT_MosSyouhn.MOSNO+" ASC ,"+HT_MosSyouhn.SYOUHNCD+" ASC ")
    public  List<HT_MosSyouhn> getMosSyouhns() {
        return hT_MosSyouhns;
    }

    public void setMosSyouhns(List<HT_MosSyouhn> pHT_MosSyouhns) {
        this.hT_MosSyouhns = pHT_MosSyouhns;
    }


}

