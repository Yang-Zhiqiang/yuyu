package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import yuyu.def.db.id.PKAS_Sequence;
import yuyu.def.db.mapping.GenAS_Sequence;
import yuyu.def.db.meta.GenQAS_Sequence;
import yuyu.def.db.meta.QAS_Sequence;

import com.google.common.collect.Lists;

/**
 * 連番管理基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_Sequence} の JavaDoc を参照してください。
 * @see     GenAS_Sequence
 * @see     PKAS_Sequence
 * @see     QAS_Sequence
 * @see     GenQAS_Sequence
 */
@Entity
public class AS_Sequence extends GenAS_Sequence {

    private static final long serialVersionUID = 1L;

    public AS_Sequence() {
    }

    public AS_Sequence(String pId) {
        super(pId);
    }

    private List<AT_SequenceValue> aT_SequenceValues = Lists.newLinkedList();

    public AT_SequenceValue createSequenceValue() {
        AT_SequenceValue aT_SequenceValue = new AT_SequenceValue();
        aT_SequenceValue.setSequence(this);
        aT_SequenceValue.setId(this.getId());
        getSequenceValues().add(aT_SequenceValue);
        return aT_SequenceValue;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    @JoinColumn(name = AS_Sequence.ID, referencedColumnName = AT_SequenceValue.ID, insertable=false, updatable=false)
    public List<AT_SequenceValue> getSequenceValues(){
        return aT_SequenceValues;
    }

    public void setSequenceValues(List<AT_SequenceValue> pAT_SequenceValues){
        aT_SequenceValues = pAT_SequenceValues;
    }

    ////    @OneToMany(
    ////            targetEntity = AT_SequenceValue.class,
    ////            fetch = FetchType.LAZY,
    ////            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE},
    ////            orphanRemoval = true,
    ////            mappedBy = "aS_Sequence")
    //    private List<AT_SequenceValue> aT_SequenceValues;
    //
    //    public AT_SequenceValue creatreSequenceValue() {
    //        AT_SequenceValue aT_SequenceValue = new AT_SequenceValue();
    //        aT_SequenceValue.setSequence(this);
    //        aT_SequenceValue.setId(this.getId());
    //        getSequenceValues().add(aT_SequenceValue);
    //        return aT_SequenceValue;
    //    }
    //
    //    @OneToMany
    //    @JoinColumn(name=AS_Sequence.ID)
    //    public List<AT_SequenceValue> getSequenceValues() {
    //        return aT_SequenceValues;
    //    }
    //
    //    public void setSequenceValues(List<AT_SequenceValue> sequenceValues) {
    //        aT_SequenceValues = readyChildEntityList(sequenceValues);
    //    }

    // AS_Sequence とか AT_SequenceValue は swak-sequence 管理下のテーブルなので、勝手にリレーションとか張っちゃダメ！
    // リレーションシップなんぞ有ろうが無かろうが全く関係ない（つか、有っても使わねぇ）し、ヘタすると遅くなるだけ。
    // 何でもかんでもリレーション張りゃぁ良いって訳じゃ.. (ry
    //   2014/03/17 T.Hoshino

}
