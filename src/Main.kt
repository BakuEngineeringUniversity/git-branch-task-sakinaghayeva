import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.errors.GitAPIException
import java.io.File

fun <GitAPIException> createBranch(repositoryPath: String, newBranchName: String): Boolean {
    return try {
        // Open the existing repository
        val git = Git.open(File(repositoryPath))

        // Create the new branch
        git.branchCreate()
            .setName(newBranchName)
            .call()

        println("Branch '$newBranchName' created successfully.")
        true
    } catch (e: GitAPIException) {
        e.printStackTrace()
        false
    }
}



fun main() {
    val repoPath = "/path/to/your/repo"
    val branchName = "new-feature-branch"

    val isBranchCreated = createBranch(repoPath, branchName)
    if (isBranchCreated) {
        println("Branch creation task completed successfully.")
    } else {
        println("Branch creation task failed.")
    }
