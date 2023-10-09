/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress(
    "unused",
    "nothing_to_inline",
    "useless_cast",
    "unchecked_cast",
    "extension_shadowed_by_member",
    "redundant_projection",
    "RemoveRedundantBackticks",
    "ObjectPropertyName",
    "deprecation"
)
@file:org.gradle.api.Generated

/* ktlint-disable */

package gradle.kotlin.dsl.accessors._82d2c2d6084bd92195563500a586d689


import org.gradle.api.Action


/**
 * Retrieves the [defaultArtifacts][org.gradle.api.internal.plugins.DefaultArtifactPublicationSet] extension.
 */
internal
val org.gradle.api.Project.`defaultArtifacts`: org.gradle.api.internal.plugins.DefaultArtifactPublicationSet
    get() =
        (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("defaultArtifacts") as org.gradle.api.internal.plugins.DefaultArtifactPublicationSet

/**
 * Configures the [defaultArtifacts][org.gradle.api.internal.plugins.DefaultArtifactPublicationSet] extension.
 */
internal
fun org.gradle.api.Project.`defaultArtifacts`(configure: Action<org.gradle.api.internal.plugins.DefaultArtifactPublicationSet>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure(
        "defaultArtifacts",
        configure
    )



