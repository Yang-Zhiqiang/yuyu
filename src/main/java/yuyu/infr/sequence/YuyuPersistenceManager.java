package yuyu.infr.sequence;

import javax.inject.Singleton;

import jp.co.slcs.swak.sequence.Sequence;
import jp.co.slcs.swak.sequence.SequenceValue;
import jp.co.slcs.swak.sequence.persistence.jpa.SwakDbPersistenceManager;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.id.PKAS_Sequence;
import yuyu.def.db.id.PKAT_SequenceValue;

/**
 * swak-sequence基盤の永続化マネージャー実装クラスです。
 */
@Singleton
public class YuyuPersistenceManager extends SwakDbPersistenceManager<AS_Sequence, PKAS_Sequence, AT_SequenceValue, PKAT_SequenceValue> {

    @Override
    protected PKAS_Sequence constructSequencePk(String sequenceId) {
        return new PKAS_Sequence(sequenceId);
    }

    @Override
    protected PKAT_SequenceValue constructSequenceValuePk(Sequence seq, String sequenceKeys) {
        return new PKAT_SequenceValue(seq.getId(), sequenceKeys);
    }

    @Override
    protected AT_SequenceValue constructSequenceValueEntity(SequenceValue sequenceValue) {
        AT_SequenceValue sv = new AT_SequenceValue();
        sv.setId(sequenceValue.getSequence().getId());
        sv.setKeys(sequenceValue.getKeys());
        sv.setCurrentValue(sequenceValue.getCurrentValue());
        return sv;
    }

    @Override
    protected Sequence constructSequence(AS_Sequence sequenceEntity) {
        Sequence s = new Sequence();
        s.setId(sequenceEntity.getId());
        s.setName(sequenceEntity.getName());
        s.setIncrement(sequenceEntity.getIncrease());
        s.setCacheSize(sequenceEntity.getCacheSize());
        s.setLength(sequenceEntity.getLength());
        s.setMaxValue(sequenceEntity.getMaxValue());
        s.setPadding(C_UmuKbn.ARI.equals(sequenceEntity.getPadding()));
        s.setStartWith(sequenceEntity.getStartWith());
        return s;
    }

    @Override
    protected long getSequenceCurrentValue(AT_SequenceValue sequenceValueEntity) {
        return sequenceValueEntity.getCurrentValue();
    }

    @Override
    protected void setSequenceCurrentValue(AT_SequenceValue sequenceValueEntity, long value) {
        sequenceValueEntity.setCurrentValue(value);
    }

}
