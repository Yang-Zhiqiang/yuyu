CREATE VIEW ZT_DrtenMinyuKykDtlSyokaiRn AS SELECT
     zrnsakuseiym ,         /* （連携用）作成年月 */
     zrnbsydrtencd ,         /* （連携用）募集代理店コード */
     zrntntusycd ,         /* （連携用）担当者コード */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnpjyuutouyymmwareki4keta ,         /* （連携用）保険料充当年月（和暦）（４桁） */
     zrnkykymwareki4keta ,         /* （連携用）契約年月（和暦）（４桁） */
     zrncifcd ,         /* （連携用）ＣＩＦコード */
     zrnatesakinm ,         /* （連携用）宛先名 */
     zrnminyuujyutuymdyofuri ,         /* （連携用）未入充当年月（預振） */
     zrnminyuujyutuymdyofuriigi ,         /* （連携用）未入充当年月（預振以外） */
     zrnhassinka ,         /* （連携用）発信課 */
     zrntelno15keta ,         /* （連携用）電話番号（１５桁） */
     zrnbsyymwareki4keta ,         /* （連携用）募集年月（和暦）（４桁） */
     zrntntusynm ,         /* （連携用）担当者名 */
     zrnkydatkikbnkj ,         /* （連携用）共同扱区分（漢字） */
     zrnkyknmkj20 ,         /* （連携用）契約者名（漢字）（２０桁） */
     zrnhrkkaisuukj ,         /* （連携用）払込回数（漢字） */
     zrnhrkkeirokj ,         /* （連携用）払込経路（漢字） */
     zrnp11keta ,         /* （連携用）保険料（１１桁） */
     zrnknkimnyuuryukj ,         /* （連携用）今回未入理由（漢字） */
     zrnjikaiminyuuji ,         /* （連携用）次回未入時 */
     zrntntusygyouhaiinfo ,         /* （連携用）担当者業廃情報 */
     zrnhrkkeirobtjhmidasi ,         /* （連携用）払込経路別情報見出し */
     zrnhrkkeirobtjh ,         /* （連携用）払込経路別情報 */
     zrnhknsyuruimei ,         /* （連携用）保険種類名 */
     zrnbkofccd ,         /* （連携用）バックオフィスコード */
     zrndbskyoteiymd ,         /* （連携用）ＤＢ削除予定年月 */
     zrnyobiv24           /* （連携用）予備項目Ｖ２４ */
FROM ZT_DrtenMinyuKykDtlSyokaiRn_Z;