/**
 * Copyright (C) 2016 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.
 *
 * The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.blackducksoftware.integration.fortify.parser;

import java.math.BigDecimal;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.univocity.parsers.annotations.Parsed;

/**
 * Bean mapped to output of the Hub CSV report
 * If the columns change, the mappings here will need to be updated.
 *
 * @author akamen
 *
 */
public class BlackDuckIssue {
    private static Logger LOG = LoggerFactory.getLogger(BlackDuckIssue.class);

    /**
     * Unique natural issue identifier.
     */
    private String issueId;

    @Parsed(field = "Project name")
    private String projectName;

    @Parsed(field = "Project version")
    private String projectVersion;

    @Parsed(field = "Project id")
    private String projectId;

    @Parsed(field = "Version id")
    private String versionId;

    @Parsed(field = "Channel version id")
    private String channelVersionId;

    @Parsed(field = "Component name")
    private String componentName;

    @Parsed(field = "Version")
    private String version;

    @Parsed(field = "Channel version origin")
    private String channelVersionOrigin;

    @Parsed(field = "Channel version origin id")
    private String channelVersionOriginId;

    @Parsed(field = "Channel version origin name")
    private String channelVersionOriginName;

    @Parsed(field = "Vulnerability id")
    private String vulnerabilityId;

    @Parsed(field = "Description")
    private String description;

    @Parsed(field = "Published on")
    private String publishedOn;

    @Parsed(field = "Updated on")
    private String updatedOn;

    @Parsed(field = "Base Score")
    private BigDecimal baseScore;

    @Parsed(field = "Exploitability")
    private BigDecimal exploitability;

    @Parsed(field = "Impact")
    private BigDecimal impact;

    @Parsed(field = "Vulnerability source")
    private String vulnerabilitySource;

    @Parsed(field = "Hub Vulnerability URL")
    private String hubVulnerabilityUrl;

    @Parsed(field = "Remediation status")
    private String remediationStatus;

    @Parsed(field = "Remediation target date")
    private String remediationTargetDate;

    @Parsed(field = "Remediation actual date")
    private String remediationActualDate;

    @Parsed(field = "Remediation comment")
    private String remediationComment;

    @Parsed(field = "URL")
    private String URL;

    @Parsed(field = "Severity")
    private String severity;

    @Parsed(field = "Scan date")
    private String scanDate;

    @Parsed(field = "Upgrade Version")
    private String upgradeVersion;

    @Parsed(field = "Upgrade Version Released On")
    private String upgradeVersionReleasedOn;

    @Parsed(field = "Latest Version")
    private String latestVersion;

    @Parsed(field = "Latest Version Released On")
    private String latestVersionReleasedOn;

    /**
     * Returns the unique ID of this particular issue.
     * Using an internal id plus the supplied name via the setId()
     * Format will be supplied name during setid + ":" + vulnerability ID
     *
     * @return unique issue ID
     */
    public String getId() {
        if (issueId == null) {
            final String uuidData = String.format("%s:%s:%s:%s", BlackDuckUtils.cleanName(componentName), BlackDuckUtils.cleanName(version),
                    BlackDuckUtils.cleanName(channelVersionOriginId), vulnerabilityId);
            issueId = UUID.nameUUIDFromBytes(uuidData.getBytes()).toString();
            LOG.debug("Component name~" + BlackDuckUtils.cleanName(componentName) + "version~" + BlackDuckUtils.cleanName(version)
                    + ", channel version origin id~" + BlackDuckUtils.cleanName(channelVersionOriginId) + ", vulnerabilityId~" + vulnerabilityId
                    + ", issueId~" + issueId);
        }
        return issueId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(final String projectName) {
        this.projectName = projectName;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(final String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(final String projectId) {
        this.projectId = projectId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(final String versionId) {
        this.versionId = versionId;
    }

    public String getChannelVersionId() {
        return channelVersionId;
    }

    public void setChannelVersionId(final String channelVersionId) {
        this.channelVersionId = channelVersionId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(final String componentName) {
        this.componentName = componentName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public String getChannelVersionOrigin() {
        return channelVersionOrigin;
    }

    public void setChannelVersionOrigin(final String channelVersionOrigin) {
        this.channelVersionOrigin = channelVersionOrigin;
    }

    public String getChannelVersionOriginId() {
        return channelVersionOriginId;
    }

    public void setChannelVersionOriginId(final String channelVersionOriginId) {
        this.channelVersionOriginId = channelVersionOriginId;
    }

    public String getChannelVersionOriginName() {
        return channelVersionOriginName;
    }

    public void setChannelVersionOriginName(final String channelVersionOriginName) {
        this.channelVersionOriginName = channelVersionOriginName;
    }

    public String getVulnerabilityId() {
        return vulnerabilityId;
    }

    public void setVulnerabilityId(final String vulnerabilityId) {
        this.vulnerabilityId = vulnerabilityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(final String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(final String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public BigDecimal getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(final BigDecimal baseScore) {
        this.baseScore = baseScore;
    }

    public BigDecimal getExploitability() {
        return exploitability;
    }

    public void setExploitability(final BigDecimal exploitability) {
        this.exploitability = exploitability;
    }

    public BigDecimal getImpact() {
        return impact;
    }

    public void setImpact(final BigDecimal impact) {
        this.impact = impact;
    }

    public String getVulnerabilitySource() {
        return vulnerabilitySource;
    }

    public void setVulnerabilitySource(final String vulnerabilitySource) {
        this.vulnerabilitySource = vulnerabilitySource;
    }

    public String getHubVulnerabilityUrl() {
        return hubVulnerabilityUrl;
    }

    public void setHubVulnerabilityUrl(final String hubVulnerabilityUrl) {
        this.hubVulnerabilityUrl = hubVulnerabilityUrl;
    }

    public String getRemediationStatus() {
        return remediationStatus;
    }

    public void setRemediationStatus(final String remediationStatus) {
        this.remediationStatus = remediationStatus;
    }

    public String getRemediationTargetDate() {
        return remediationTargetDate;
    }

    public void setRemediationTargetDate(final String remediationTargetDate) {
        this.remediationTargetDate = remediationTargetDate;
    }

    public String getRemediationActualDate() {
        return remediationActualDate;
    }

    public void setRemediationActualDate(final String remediationActualDate) {
        this.remediationActualDate = remediationActualDate;
    }

    public String getRemediationComment() {
        return remediationComment;
    }

    public void setRemediationComment(final String remediationComment) {
        this.remediationComment = remediationComment;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(final String uRL) {
        URL = uRL;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(final String severity) {
        this.severity = severity;
    }

    public String getScanDate() {
        return scanDate;
    }

    public void setScanDate(final String scanDate) {
        this.scanDate = scanDate;
    }

    public String getUpgradeVersion() {
        return upgradeVersion;
    }

    public void setUpgradeVersion(final String upgradeVersion) {
        this.upgradeVersion = upgradeVersion;
    }

    public String getUpgradeVersionReleasedOn() {
        return upgradeVersionReleasedOn;
    }

    public void setUpgradeVersionReleasedOn(final String upgradeVersionReleasedOn) {
        this.upgradeVersionReleasedOn = upgradeVersionReleasedOn;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(final String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getLatestVersionReleasedOn() {
        return latestVersionReleasedOn;
    }

    public void setLatestVersionReleasedOn(final String latestVersionReleasedOn) {
        this.latestVersionReleasedOn = latestVersionReleasedOn;
    }

}
