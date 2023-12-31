CREATE VIEW IT_KhHenkouUktkYendtHnk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     hozenhenkouuktkrenno ,         /* 保全変更受付連番 */
     yendthnkymd ,         /* 円建変更日 */
     mkhgktttymd ,         /* 目標額到達日 */
     mkhgktttkaiyakuhr ,         /* 目標額到達時解約返戻金 */
     mkhgktttkaiyakuhr$ ,         /* 目標額到達時解約返戻金(通貨型) */
     newkaiyakuhr ,         /* 変更後解約返戻金 */
     newkaiyakuhr$ ,         /* 変更後解約返戻金(通貨型) */
     yendthnkhr ,         /* 円建変更時返戻金 */
     yendthnkhr$ ,         /* 円建変更時返戻金(通貨型) */
     nyuuryokuhassoukbn ,         /* 入力発送区分 */
     hnskariyuu1 ,         /* 本社回送理由１ */
     hnskariyuu2 ,         /* 本社回送理由２ */
     yendthnkkaiyakuhrgaika ,         /* 円建変更時解約返戻金（外貨） */
     yendthnkkaiyakuhrgaika$ ,         /* 円建変更時解約返戻金（外貨）(通貨型) */
     yendthnkkaiyakuhryen ,         /* 円建変更時解約返戻金（円貨） */
     yendthnkkaiyakuhryen$ ,         /* 円建変更時解約返戻金（円貨）(通貨型) */
     yendthnkjikwsrate ,         /* 円建変更時為替レート */
     newsyouhncd ,         /* 変更後商品コード */
     newsyouhnsdno ,         /* 変更後商品世代番号 */
     yendthnkkihons ,         /* 円建変更後基本Ｓ */
     yendthnkkihons$ ,         /* 円建変更後基本Ｓ(通貨型) */
     newhokenryou ,         /* 変更後保険料 */
     newhokenryou$ ,         /* 変更後保険料(通貨型) */
     newkyktuukasyu ,         /* 変更後契約通貨種類 */
     newryouritusdno ,         /* 変更後料率世代番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     syoruiukeymd ,         /* 書類受付日 */
     newtumitateriritu ,         /* 変更後積立利率 */
     newyoteiriritu           /* 変更後予定利率 */
FROM IT_KhHenkouUktkYendtHnk_Z;