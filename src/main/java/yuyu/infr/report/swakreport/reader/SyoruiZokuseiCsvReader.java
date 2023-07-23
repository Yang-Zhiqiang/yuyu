package yuyu.infr.report.swakreport.reader;

import java.util.HashMap;
import java.util.Map;

import jp.co.slcs.swak.core.resource.ConfigFile;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;

/**
 * csv形式で記述された書類属性情報ファイルから書類属性情報を読み込む為のクラスです。<br />
 * 書類属性csvファイルは以下のような書式で conf/syorui-zokusei.csv というファイル名で保存してください。
 */
public class SyoruiZokuseiCsvReader extends SyoruiZokuseiReader {

    private static final String SYORUI_ZOKUSEI_CSV_FILE_NAME = "syorui-zokusei.csv";

    private static final int    SYORUI_ZOKUSEI_CSV_FIELDS    = 15;

    @Override
    public Map<String, SyoruiZokusei> read() {
        final Map<String, SyoruiZokusei> syoruiZokuseiMap = new HashMap<String, SyoruiZokusei>();

        new CsvReader(ConfigFile.getConfigFileStream(SYORUI_ZOKUSEI_CSV_FILE_NAME), SYORUI_ZOKUSEI_CSV_FIELDS) {

            @Override
            protected boolean readLine(int pLineNo, String[] pValues) {
                if (pLineNo == 1) {

                    return true;
                }

                if (pValues.length == 0) {
                    return false;
                }

                C_SyoruiCdKbn syoruiCdKbn   = C_SyoruiCdKbn.valueOf(pValues[0]);
                String syoruiNm             = pValues[1];
                String syoruiNmRyaku        = pValues[2];
                String tyouhyouFormId       = pValues[3];
                long hozonKkn               = Long.parseLong(pValues[4]);
                C_NengetuKbn nengetuKbn     = C_NengetuKbn.valueOf(pValues[5]);
                C_YesNoKbn pdfHozonKbn      = C_YesNoKbn.valueOf(pValues[6]);
                C_YesNoKbn zipHozonKbn      = C_YesNoKbn.valueOf(pValues[7]);
                int pageCount               = Integer.parseInt(pValues[8]);
                int sortNo                  = Integer.parseInt(pValues[9]);
                String kensakuKeyKoumokuId1 = pValues[10];
                String kensakuKeyKoumokuId2 = pValues[11];
                String kensakuKeyKoumokuId3 = pValues[12];
                String kensakuKeyKoumokuId4 = pValues[13];
                String kensakuKeyKoumokuId5 = pValues[14];

                syoruiZokuseiMap.put(syoruiCdKbn.getValue(), new SyoruiZokusei(syoruiCdKbn,
                        syoruiNm,
                        syoruiNmRyaku,
                        tyouhyouFormId,
                        hozonKkn,
                        nengetuKbn,
                        C_YesNoKbn.NO,
                        pdfHozonKbn,
                        zipHozonKbn,
                        pageCount,
                        sortNo,
                        kensakuKeyKoumokuId1,
                        kensakuKeyKoumokuId2,
                        kensakuKeyKoumokuId3,
                        kensakuKeyKoumokuId4,
                        kensakuKeyKoumokuId5));

                return true;
            }
        } .process();

        return syoruiZokuseiMap;
    }

}
