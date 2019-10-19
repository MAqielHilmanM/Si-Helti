package com.automosen.si_helti.network.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MalariaDao {
    @SerializedName("id_malaria") @Expose val id_malaria: Int?= null
    @SerializedName("org_name") @Expose val org_name: String?= null
    @SerializedName("site_name") @Expose val site_name: String?= null
    @SerializedName("latitude") @Expose val latitude: String?= null
    @SerializedName("longitude") @Expose val longitude: String?= null
    @SerializedName("elevation") @Expose val elevation: String?= null
    @SerializedName("measured_on") @Expose val measured_on: String?= null
    @SerializedName("mosquito_habitat_mappermosquito_habitat_mapper_id") @Expose val mosquito_habitat_mappermosquito_habitat_mapper_id: String?= null
    @SerializedName("mosquito_habitat_mapperdata_source") @Expose val mosquito_habitat_mapperdata_source: String?= null
    @SerializedName("mosquito_habitat_mapperuserid") @Expose val mosquito_habitat_mapperuserid: String?= null
    @SerializedName("mosquito_habitat_mappermeasured_at") @Expose val mosquito_habitat_mappermeasured_at: String?= null
    @SerializedName("mosquito_habitat_mapperwater_source_type") @Expose val mosquito_habitat_mapperwater_source_type: String?= null
    @SerializedName("mosquito_habitat_mapperwater_source") @Expose val mosquito_habitat_mapperwater_source: String?= null
    @SerializedName("mosquito_habitat_mapperlarvae_count") @Expose val mosquito_habitat_mapperlarvae_count: String?= null
    @SerializedName("mosquito_habitat_mappermosquito_eggs") @Expose val mosquito_habitat_mappermosquito_eggs: String?= null
    @SerializedName("mosquito_habitat_mappermosquito_egg_count") @Expose val mosquito_habitat_mappermosquito_egg_count: String?= null
    @SerializedName("mosquito_habitat_mappermosquito_pupae") @Expose val mosquito_habitat_mappermosquito_pupae: String?= null
    @SerializedName("mosquito_habitat_mappermosquito_adults") @Expose val mosquito_habitat_mappermosquito_adults: String?= null
    @SerializedName("mosquito_habitat_mapperlast_identify_stage") @Expose val mosquito_habitat_mapperlast_identify_stage: String?= null
    @SerializedName("mosquito_habitat_mappergenus") @Expose val mosquito_habitat_mappergenus: String?= null
    @SerializedName("mosquito_habitat_mapperspecies") @Expose val mosquito_habitat_mapperspecies: String?= null
    @SerializedName("mosquito_habitat_mapperbreeding_ground_eliminated") @Expose val mosquito_habitat_mapperbreeding_ground_eliminated: String?= null
    @SerializedName("mosquito_habitat_mapperextra_data") @Expose val mosquito_habitat_mapperextra_data: String?= null
    @SerializedName("mosquito_habitat_mapperwater_source_photo_urls") @Expose val mosquito_habitat_mapperwater_source_photo_urls: String?= null
    @SerializedName("mosquito_habitat_mapperlarva_full_body_photo_urls") @Expose val mosquito_habitat_mapperlarva_full_body_photo_urls: String?= null
    @SerializedName("mosquito_habitat_mapperabdomen_closeup_photo_urls") @Expose val mosquito_habitat_mapperabdomen_closeup_photo_urls: String?= null
    @SerializedName("mosquito_habitat_mappercomments") @Expose val mosquito_habitat_mappercomments: String?= null
}